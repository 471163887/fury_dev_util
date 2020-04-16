#!/bin/bash
echo "新的版本号：$1";
# 设置新的版本号并提交修改
mvn versions:set -DnewVersion=$1
mvn versions:commit