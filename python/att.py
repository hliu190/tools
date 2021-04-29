#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr 28 23:04:03 2021

@author: hulkliu

audio to text
"""

import speech_recognition as sr
import sys

# initialize the recognizer
r = sr.Recognizer()
# open the file
with sr.AudioFile(sys.argv[1]) as source:
    # listen for the data (load audio to memory)
    audio_data = r.record(source)
    # recognize (convert from speech to text)
    text = r.recognize_google(audio_data)
    print(text)
