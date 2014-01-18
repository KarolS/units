#!/bin/bash

# https://github.com/scoverage/scalac-scoverage-plugin/issues/7

PROJECTS_TO_FIX="units units-algebird units-joda units-scalacheck units-scalaz units-slick units-spire"

for PROJECT in $PROJECTS_TO_FIX ; do
    cd "$( dirname "$0")"
    cd $PROJECT
    cd target/scala-2.10/scoverage-report
    for TARGET in `find . -name '*.scala.html'` ; do
        TARGET=$(echo $TARGET|sed -e 's|^\./||')
        PWD=`pwd`
        for FILE_TO_FIX in `find . -name '*[^a].html'` ; do
            REPLACE_FROM=$(basename $TARGET)
            SED_COMMAND="s|href=\"$PWD/\\([^/\"]*/\\)*$REPLACE_FROM\"|href=\"$PWD/$TARGET\"|g"
            sed -i -e "$SED_COMMAND" $FILE_TO_FIX
        done
    done
done
