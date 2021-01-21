# e.g. ./rundecksync-latest -token fhUSDx4bQOVinVhNFlTKgi6gixjiideD -version 1.1.152-tfs18502-360Logica 


param (  
    [string]$token = $(throw "-token is required."),
    [string]$version = $(throw "-version is required.")
)



function sync_jobs {
param (  
    [string]$token = $(throw "-token is required."),
    [string]$version = $(throw "-version is required.")
)

$rundeck_vars="rd_jobName=`${job.name} rd_jobid=`${job.id} rd_jobExecId=`${job.execid} rd_jobProject=`${job.project} rd_jobGroup=`${job.group} rd_username=`${job.username} rd_userEmail=`${job.user.email} rd_deployReason=RunDeck-trigger:`${job.executionType} "

$default_rundeck_selenium_folder="integration/vin.com/int/int01/Selenium"
$project_name="self-service"
$body= @'
'@

$list_test_cases=""
foreach($testcase in Get-Content .\testcases.list) {
		if($list_test_cases.length -ne 0)
		{
			$list_test_cases+=','
		}
		$list_test_cases+=$testcase
}

$body+= generateYaml -rundeck_job_name "Selenium test case execution - version $version" -test_cases_list $list_test_cases -ansible_params "-i ~/ansible/inventories/vin_int01/hosts -e 'myPlaybook=vin/selenium jarVersion=$version targetEnv=`${option.targetEnv} browser=`${option.browser} testTimeout=`${option.testTimeout} testCase=`${option.testCase} testType=testcase $rundeck_vars' "


$list_test_suites=""
foreach($testsuite in Get-Content .\testsuites.list) {
		if($list_test_suites.length -ne 0)
		{
			$list_test_suites+=','
		}
		$list_test_suites+=$testsuite
}


$body+= generateYamlSuite -rundeck_job_name "Selenium test suite execution - version $version" -test_suites_list $list_test_suites -ansible_params "-i ~/ansible/inventories/vin_int01/hosts -e 'myPlaybook=vin/selenium jarVersion=$version targetEnv=`${option.targetEnv} browser=`${option.browser} testTimeout=`${option.testTimeout} testSuite=`${option.testSuite} testType=testsuite $rundeck_vars' "

Write-Host $body

# Required API Variables
$uri = "http://rundeck.vin.com:4440/api/31/project/${project_name}/jobs/import?uuidOption=remove&dupeOption=update"

$headers = @{
    'X-Rundeck-Auth-Token' = $token
}

# RESTful API Call
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
Invoke-WebRequest -Uri $uri -Method Post -Body $body -Headers $headers -ContentType 'application/yaml'

}


function generateYaml {
    param (  
    [string]$pathRepoRundeck   = '~/ansible',
    [string]$ansible_params    = "-i ~/ansible/inventories/vin_int01/hosts -e 'myPlaybook=vin/selenium jar_version=1.1.152-tfs18502-360Logica env=alpha browser=chrome test_timeout=600 env=beta testCase=MyCE testtype=testcase' ",
    [string]$ansible_playbook  = '~/ansible/play/main.yml',
    [string]$rundeck_job_name  = 'Selenium',
    [string]$rundeck_job_group = 'selenium',
	[string]$env_list = 'qa,beta,www,alpha,dev',
	[string]$test_cases_list = 'BoardsDraftHappyPath,BoardsLanding,MyCE'
    )


$jobDef = @'

    - defaultTab: output
      description: ''
      executionEnabled: true
      group: %rundeck_job_group%
      loglevel: INFO
      multipleExecutions: true
      name: %rundeck_job_name%
      nodeFilterEditable: false
      options:
      - enforced: true
        label: Environment
        name: targetEnv
        required: true
        values: [%env_list%]
        valuesListDelimiter: ','
      - enforced: true
        label: Test Case
        name: testCase
        required: true
        values: [%test_cases_list%]
        valuesListDelimiter: ','
      - enforced: true
        label: Browser
        name: browser
        required: true
        values: [chrome,firefox]
        valuesListDelimiter: ','
      - enforced: true
        label: Time Out
        name: testTimeout
        required: true
        values:
        - 600
        - 3600
        - 7200
        valuesListDelimiter: ','
      scheduleEnabled: true
      sequence:
        commands:
        - description: ansible
          exec: ansible-playbook %ansible_playbook% %ansible_params%" 
        keepgoing: false
        strategy: node-first


'@

    $jobDef=$jobDef.replace("%ansible_params%",$ansible_params)
    $jobDef=$jobDef.replace("%ansible_playbook%",$ansible_playbook)
    $jobDef=$jobDef.replace("%rundeck_job_name%",$rundeck_job_name)
    $jobDef=$jobDef.replace("%rundeck_job_group%",$rundeck_job_group)   
	$jobDef=$jobDef.replace("%env_list%",$env_list)
	$jobDef=$jobDef.replace("%test_cases_list%",$test_cases_list)
    return $jobDef
}



function generateYamlSuite {
    param (  
    [string]$pathRepoRundeck   = '~/ansible',
    [string]$ansible_params    = "-i ~/ansible/inventories/vin_int01/hosts -e 'myPlaybook=vin/selenium jar_version=1.1.152-tfs18502-360Logica env=alpha browser=chrome test_timeout=600 env=beta testSuite=x testtype=testsuite' ",
    [string]$ansible_playbook  = '~/ansible/play/main.yml',
    [string]$rundeck_job_name  = 'Selenium',
    [string]$rundeck_job_group = 'selenium',
	[string]$env_list = 'qa,beta,www,alpha,dev',
	[string]$test_suites_list = ''
    )


$jobDef = @'
    - defaultTab: nodes
      description: ''
      executionEnabled: true
      group: %rundeck_job_group%
      loglevel: INFO
      multipleExecutions: true
      name: %rundeck_job_name%
      nodeFilterEditable: false
      options:
      - enforced: true
        label: Environment
        name: targetEnv
        required: true
        values: [%env_list%]
        valuesListDelimiter: ','
      - enforced: true
        label: Test Suite
        name: testSuite
        required: true
        values: [%test_suites_list%]
        valuesListDelimiter: ','
      - enforced: true
        label: Time Out
        name: testTimeout
        required: true
        values:
        - 600
        - 3600
        - 7200
        valuesListDelimiter: ','
      scheduleEnabled: true
      sequence:
        commands:
        - description: ansible
          exec: ansible-playbook %ansible_playbook% %ansible_params%" 
        keepgoing: false
        strategy: node-first


'@

    $jobDef=$jobDef.replace("%ansible_params%",$ansible_params)
    $jobDef=$jobDef.replace("%ansible_playbook%",$ansible_playbook)
    $jobDef=$jobDef.replace("%rundeck_job_name%",$rundeck_job_name)
    $jobDef=$jobDef.replace("%rundeck_job_group%",$rundeck_job_group)   
	$jobDef=$jobDef.replace("%env_list%",$env_list)
	$jobDef=$jobDef.replace("%test_suites_list%",$test_suites_list)
    return $jobDef
}



sync_jobs -token $token -version $version