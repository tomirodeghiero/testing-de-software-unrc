
fullclassname=$1

packagename=${fullclassname%\.*}
#classname=${fullclassname##*\.}

timelimit=${2:-30}
outputlimit=${3:-400}
testsperfile=${4:-200}


java -classpath target/classes:libs/randoop-all-3.0.8.jar randoop.main.Main gentests --testclass="$fullclassname" --timelimit="$timelimit" --outputlimit="$outputlimit" --testsperfile="$testsperfile" --small-tests=true --junit-output-dir=src/test/java --junit-package-name="$packagename" --forbid-null=false --null-ratio=0.5 --npe-on-null-input=ERROR --npe-on-non-null-input=ERROR #--unchecked-exception=ERROR
