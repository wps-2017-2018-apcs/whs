#!/usr/bin/env sh
# Delete all extraneous files from all subdirectories in $1 (or src).
DIR=${1:-src}
for EXT in \~ class
do
	echo \# ${EXT}
	find ${DIR} -print |grep ${EXT}$ |xargs -n 1 -I {} -t rm {}
done
