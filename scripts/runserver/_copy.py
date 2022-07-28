from re import S
from shutil import copyfile
from sys import exit
import os

source = './HelloWorld.jar'
target = './plugins/HelloWorld.jar'
if(os.path.exists(target) is True):
    os.remove(target)
    copyfile(source,target)
    print('Target already exists, python had delete it and copied source into that folder.')
else:
    copyfile(source,target)
    print('Copied successfully.')
