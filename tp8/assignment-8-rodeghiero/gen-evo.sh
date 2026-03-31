#parameter full class name
classname=$1
time=$2
java -jar libs/evosuite-1.2.0.jar  -projectCP target/classes/ -class "$classname" -Dsearch_budget="$time" -Dstopping_condition=MaxTime -Duse_separate_classloader=false -Dcheck_contracts=true -Dtest_dir=src/test/java
