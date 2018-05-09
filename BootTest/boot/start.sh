#!/bin/bash
export JAVA_HOME=${JAVA_HOME}
export PATH=$JAVA_HOME/bin:$PATH

cd `dirname $0`
DEPLOY_DIR=`pwd`
LOGS_DIR=$DEPLOY_DIR/logs
if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi
STDOUT_FILE=$LOGS_DIR/stdout.log
nohup java -jar $DEPLOY_DIR/overseas-shop-address.jar >> $STDOUT_FILE 2>&1 &

echo "OK!"
PIDS=`ps -ef | grep java | grep "$DEPLOY_DIR" |grep -v grep | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"