#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr 28 21:53:36 2021

@author: hulkliu

covert from vidoe to audio
"""

import sys
import moviepy.editor as mp
import re

file =  sys.argv[1]
name = re.search('\.[0-9a-zA-Z]*$',file).group()
mp.VideoFileClip(file).audio.write_audiofile(name+'.mp3')
