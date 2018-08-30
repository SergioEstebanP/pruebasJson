#!/bin/bash

if [ $# -gt 3 ]
then
    echo "Usage: ./s.sh repository commitSentence gitClient"
    echo "Name of online repo must be equal to name's project"
fi

if [ $# -lt 3 ]
then
    echo "Usage: ./s.sh repository commitSentence gitClient"
    echo "Name of online repo must be equal to name's project"
fi

# check if destiny folders exists, in case they not, it creates them
if [ -d /home/sergio/github/$1 ]
then
    cp -ra /mnt/c/Users/sergio.esteban/Downloads/$1/* /home/sergio/github/$1/
else
    mkdir /home/sergio/github/$1
    git init /home/sergio/github/$1
    git --git-dir=/home/sergio/github/$1/.git --work-tree=/home/sergio/github/$1/ git remote add origin git@github.com:SergioEstebanP/$1.git
    cp -ra /mnt/c/Users/sergio.esteban/Downloads/$1/* /home/sergio/github/$1/
fi

if [ -d /home/sergio/bitbucket/$1 ]
then
    cp -ra /mnt/c/Users/sergio.esteban/Downloads/$1/* /home/sergio/bitbucket/$1/
else
    mkdir /home/sergio/bitbucket/$1
    git init /home/sergio/bitbucket/$1
    git --git-dir=/home/sergio/bitbucket/$1/.git --work-tree=/home/sergio/bitbucket/$1/ git remote add origin # COMPLETAR CON LA RUTA DE BITBUCKET
    cp -ra /mnt/c/Users/sergio.esteban/Downloads/$1/* /home/sergio/bitbucket/$1/
fi

echo "Copy done ..."
echo ""

# fixing the encoding fails due to the utf8 and windows1552 encoding
sed -i 's/\r$//' github/$1/gradlew
sed -i 's/\r$//' bitbucket/$1/gradlew

if [ $# -eq 3 ]
then
    if [ "$3" == "github" ]
    then
        # then we have to update the repos
        git --git-dir=/home/sergio/github/$1/.git --work-tree=/home/sergio/github/$1/ add -A
        git --git-dir=/home/sergio/github/$1/.git --work-tree=/home/sergio/github/$1/ commit -m "$2"
        git --git-dir=/home/sergio/github/$1/.git --work-tree=/home/sergio/github/$1/ push origin master
        echo "Github update done ..."
        echo ""
    else
        git --git-dir=/home/sergio/bitbucket/$1/.git --work-tree=/home/sergio/bitbucket/$1/ add -A
        git --git-dir=/home/sergio/bitbucket/$1/.git --work-tree=/home/sergio/bitbucket/$1/ commit -m "$2"
        git --git-dir=/home/sergio/bitbucket/$1/.git --work-tree=/home/sergio/bitbucket/$1/ push origin master
        echo "Bitbucket update done ..."
        echo ""
    fi
else
    git --git-dir=/home/sergio/github/$1/.git --work-tree=/home/sergio/github/$1/ add -A
    git --git-dir=/home/sergio/github/$1/.git --work-tree=/home/sergio/github/$1/ commit -m "$2"
    git --git-dir=/home/sergio/github/$1/.git --work-tree=/home/sergio/github/$1/ push origin master
    echo "Github update done ..."
    echo ""

    git --git-dir=/home/sergio/bitbucket/$1/.git --work-tree=/home/sergio/bitbucket/$1/ add -A
    git --git-dir=/home/sergio/bitbucket/$1/.git --work-tree=/home/sergio/bitbucket/$1/ commit -m "$2"
    git --git-dir=/home/sergio/bitbucket/$1/.git --work-tree=/home/sergio/bitbucket/$1/ push origin master
    echo "Bitbucket update done ..."
    echo ""
fi





