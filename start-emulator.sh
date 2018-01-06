#!/usr/bin/env bash
cd $1
adb kill-server
adb start-server
./emulator -avd $2