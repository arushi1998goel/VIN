# script responsible for creating an artifact name + scemantic version (e.g. x.y.z) number based on :
# project name, branch and number of commit since most recent tag
# no tag => will pick 0 for patch version
# will find the most recent annotated tag in git and generate variables for tfs with the # of changes
# since the most recent annotated tag. e.g. to create one : git tag -a v1.0 -m "my description here" (let's not have a '-' in tag name.. this script won't handle it.)
# once done, the info is made available to tfs.

# how to make changes in this script? Run powershell ISE and run this into your project git folder. Switch between branches using the branch parameter.

param (
    [string]$branchName = "master"
)

########### HERE !! #####################
#this is the spot to change the Major and Minor version numbers. Feel free to change this and artifact name.
$ProjectVersion=1.1
$ProjectArtifactsName="GUIAutomatedTesting"
#########################################

#any default suffix to apply to the version no? e.g. artifact-version-$here. this used for branches typically.
$VersionBranchSuffix="-"

# tell TFS the base artifact name
"##vso[task.setvariable variable=artifactName]$ProjectArtifactsName"

if($branchName -eq "master"){
    #we're  working in master. a standard name for any artifacts here would be Artifact-Version. easy.
    $VersionBranchSuffix=""
}
else
{
    #try to avoid special char such as -, # in version suffix.
    # non master, cleanup branch name please.a standard name for any artifacts here would be Artifact-Version-BRANCHHERE. easy.
    if ($branchName.StartsWith("tfs-") -or $branchName.StartsWith("tfs#"))
    {
        $branchName="tfs"+$branchName.substring(4)
    }
    $VersionBranchSuffix="-$branchName"
}


# look at tags
$gitdesc=git describe --long --always

$charCount = ($gitdesc.ToCharArray() | Where-Object {$_ -eq '-'} | Measure-Object).Count
$vinversion = "$ProjectVersion$VersionBranchSuffix"

# expecting sth like v1.0-x-gd829df2 with the -x- the # of commits since the tag - we want to use this number..
if($charCount -ne 2){
    # not much to do here if no tags can be found, let's set the base version without a patch number. version will look shorter and we may
    # have collisions between build numbers.
    $vinversion = "$ProjectVersion$VersionBranchSuffix"
	# leave this available to be able to customize
}
else
{
     # we have excatly two -, we can isolate the # of commits
     $seenDash=$gitdesc.IndexOf("-")+1
     $seenDash2=$gitdesc.LastIndexOf("-")
     $nbChanges=$gitdesc.Substring($seenDash,$seenDash2-$seenDash)
	 $vinversion ="$ProjectVersion.$nbChanges$VersionBranchSuffix"
}
"##vso[task.setvariable variable=vinVersion]$vinversion"
"##vso[build.updatebuildnumber]$vinversion"