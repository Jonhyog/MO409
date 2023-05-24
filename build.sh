#!/bin/bash

docker run --rm --volume "$(pwd):/data" --user $(id -u):$(id -g) \
       pandoc/extra report/report.md -o report.pdf