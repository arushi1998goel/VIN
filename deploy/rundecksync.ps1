param (  
    [string]$token = $(throw "-token is required."),
    [string]$version = $(throw "-version is required."),
	[string]$browser = $(throw "-browser is required.")
)



function sync_jobs {
param (  
    [string]$token = $(throw "-token is required."),
    [string]$version = $(throw "-version is required.")
)

$rundeck_vars="rd_jobName=&apos;`${job.name}`&apos; rd_jobid=&apos;`${job.id}`&apos; rd_jobExecId=&apos;`${job.execid}`&apos; rd_jobProject=&apos;`${job.project}`&apos; rd_jobGroup=&apos;`${job.group}`&apos; rd_username=&apos;`${job.username}`&apos; rd_userEmail=&apos;`${job.user.email}`&apos; "

$default_rundeck_selenium_folder="selenium"
$project_name="self-service-selenium"


$body= @'
<joblist>

'@

$env='beta'

# test case job name prefix
$working_pref='CASE '
# test suite job name prefix
$workingSuite_pref='SUITE '
#delimit name and env
$delimit=' - '

# 1)deal with group by version
#-> each version built ends up in a version group in rundeck.. in there add cases, suites and suites with no browser specified..

#Deal with individual  testcases for current version e.g. 1.x/job name/env

$browserDisplay=$browser.ToUpper()

foreach($env in Get-Content .\environments.list) {
    foreach($testcase in Get-Content .\testcases.list) {
		$testcase_UI=$testcase.ToUpper()
		$env=$env.ToUpper()
        if($testcase.length -gt 0){ 
		
		   $jobname="${working_pref}${testcase_UI}${delimit}${env}${delimit}${version}${delimit}${browserDisplay}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=600 env=$env testCase=$testcase testtype=testcase ${rundeck_vars} `"" -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${version}/_${env}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=600 env=$env testCase=$testcase testtype=testcase ${rundeck_vars} `" " -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${version}/CASE-${testcase}"
        }
    }
}


#Deal with individual  testsuites for current version e.g. 1.x/job name/env

foreach($env in Get-Content .\environments.list) {
    foreach($testsuite in Get-Content .\testsuites.list) {
        if($testsuite.length -gt 0){ 
		   $testsuite_UI=$testsuite.ToUpper()
		   $env=$env.ToUpper()
		   $jobname="${workingSuite_pref}${testsuite_UI}${delimit}${env}${delimit}${version}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${version}/_${env}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${version}/SUITE-${testsuite}"
        }
    }
}


foreach($env in Get-Content .\environments.list) {
    foreach($testsuite in Get-Content .\testsuites-browser-spec.list) {
        if($testsuite.length -gt 0){ 
		   $testsuite_UI=$testsuite.ToUpper()
		   $env=$env.ToUpper()
		   $jobname="${workingSuite_pref}${testsuite_UI}${delimit}${env}${delimit}${version}${delimit}${browserDisplay}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "$jobname" -rundeck_job_group "${default_rundeck_selenium_folder}/${version}/_${env}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "$jobname" -rundeck_job_group "${default_rundeck_selenium_folder}/${version}/SUITE-${testsuite}"
        }
    }
}


# 2)Deal with stable/unstable jobs / testcases
#-> each version built refreshes the latest-stable or unstable group in rundeck.. in there add cases, suites and suites with no browser specified..

$group_name="_latest stable"
#  create seperate jobs : latest-stable & latest-unstable
if($version -like "*-*"){
    # unstable e.g. 1.0-logica
    $group_name="_latest unstable"
}



foreach($env in Get-Content .\environments.list) {
    foreach($testcase in Get-Content .\testcases.list) {
		$testcase_UI=$testcase.ToUpper()
		$env=$env.ToUpper()
        if($testcase.length -gt 0){ 
		
		   $jobname="${working_pref}${testcase_UI}${delimit}${env}${delimit}${browserDisplay}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=600 env=$env testCase=$testcase testtype=testcase ${rundeck_vars} `"" -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${group_name}/_${env}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=600 env=$env testCase=$testcase testtype=testcase ${rundeck_vars} `" " -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${group_name}/CASE-${testcase}"
        }
    }
}


#Deal with individual  testsuites for current version e.g. 1.x/job name/env

foreach($env in Get-Content .\environments.list) {
    foreach($testsuite in Get-Content .\testsuites.list) {
        if($testsuite.length -gt 0){ 
		   $testsuite_UI=$testsuite.ToUpper()
		   $env=$env.ToUpper()
		   $jobname="${workingSuite_pref}${testsuite_UI}${delimit}${env}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${group_name}/_${env}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "${jobname}" -rundeck_job_group "${default_rundeck_selenium_folder}/${group_name}/SUITE-${testsuite}"
        }
    }
}


foreach($env in Get-Content .\environments.list) {
    foreach($testsuite in Get-Content .\testsuites-browser-spec.list) {
        if($testsuite.length -gt 0){ 
		   $testsuite_UI=$testsuite.ToUpper()
		   $env=$env.ToUpper()
		   $jobname="${workingSuite_pref}${testsuite_UI}${delimit}${env}${delimit}${browserDisplay}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "$jobname" -rundeck_job_group "${default_rundeck_selenium_folder}/${group_name}/_${env}"
           $body+=generateJobXml -ansible_params "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=${version} browser=${browser} test_timeout=7200 env=$env testSuite=$testsuite testtype=testsuite ${rundeck_vars} `" " -rundeck_job_name "$jobname" -rundeck_job_group "${default_rundeck_selenium_folder}/${group_name}/SUITE-${testsuite}"
        }
    }
}





$body+="</joblist>"
Write-Output $body

# Required API Variables
$uri = "http://rundeck.vin.com:4440/api/31/project/${project_name}/jobs/import?uuidOption=remove&dupeOption=update"

$headers = @{
  
    'X-Rundeck-Auth-Token' = $token
}

# RESTful API Call
Invoke-WebRequest -Uri $uri -Method Post -Body $body -Headers $headers -ContentType 'application/xml'

}

function generateJobXml{
    param (  
    [string]$pathRepoRundeck   = '/var/lib/rundeck/ansible',
    [string]$ansible_params    = "-i inv_devops01 --limit localhost,* --extra-vars `"jar_version=1.1.32-tfs18502-360Logica env=alpha testCase=MyCE`"",
    [string]$ansible_playbook  = 'play_seleniumservers.yml',
    [string]$rundeck_job_name  = 'GUI Automated Testing example x',
    [string]$rundeck_job_group = 'integration/vin.com/int/int01/selenium'
    )

    $jobDef = @'
    <job>
        <defaultTab>summary</defaultTab>
        <description></description>
        <executionEnabled>true</executionEnabled>
        <group>%rundeck_job_group%</group>
        <loglevel>INFO</loglevel>
        <multipleExecutions>true</multipleExecutions>
        <name>%rundeck_job_name%</name>
        <nodeFilterEditable>false</nodeFilterEditable>
        <scheduleEnabled>true</scheduleEnabled>
        <sequence keepgoing='false' strategy='node-first'>
            <command>
            <node-step-plugin type='com.batix.rundeck.plugins.AnsiblePlaybookWorflowNodeStep'>
                <configuration>
                <entry key='ansible-base-dir-path' value='%pathRepoRundeck%' />
                <entry key='ansible-become' value='false' />
                <entry key='ansible-extra-param' value='%ansible_params%' />
                <entry key='ansible-playbook' value='%ansible_playbook%' />
                <entry key='ansible-ssh-auth-type' value='privateKey' />
                </configuration>
            </node-step-plugin>
            </command>
        </sequence>
        </job>
'@
    $jobDef=$jobDef.replace("%pathRepoRundeck%",$pathRepoRundeck)
    $jobDef=$jobDef.replace("%ansible_params%",$ansible_params)
    $jobDef=$jobDef.replace("%ansible_playbook%",$ansible_playbook)
    $jobDef=$jobDef.replace("%rundeck_job_name%",$rundeck_job_name)
    $jobDef=$jobDef.replace("%rundeck_job_group%",$rundeck_job_group)    

    return $jobDef
}

sync_jobs -token $token -version $version