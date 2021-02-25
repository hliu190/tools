# -*- coding: utf-8 -*-
"""
Created on Thu Feb 25 14:11:03 2021

@author: Hulk
"""
"""
This function is to test the running time of another function
"""
import time
def timer(fun,times=1000,*args,**kwargs):
    start = time.time()
    for i in range(times):
        fun(*args, **kwargs)
    end = time.time()
    druation=end-start
    print(f'It took {druation}s')

