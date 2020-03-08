#Find the list of artifacts found in the artifactory
curl  http://10.199.0.231:5040/artifactory/libs-snapshot-local/com/ProteinStore/1.0-SNAPSHOT/ | grep ProteinStore> $PWD/artfiles.txt
txtFile="$PWD/artfiles.txt"
#Find the last deployed artifact
line=`tail -n 1 $txtFile`
line=`echo $line | cut -d "\"" -f 2`
#Build the URL for downloading
url="http://10.199.0.231:5040/artifactory/libs-snapshot-local/com/ProteinStore/1.0-SNAPSHOT/$line"
warFile="$PWD/ProteinStore.war"
#Download the latest war file from the Artifactory and place it in project folder
wget -O $warFile $url
#Remove the temporary file generated
rm $txtFile

