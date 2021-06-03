#!/usr/bin/env python3
""" Yu finishes cooking while Max cleans """

import threading
import time

def kitchen_cleaner():
    while True:
        print('Max cleaned the kitchen.')
        time.sleep(1)

if __name__ == '__main__':
    max = threading.Thread(target=kitchen_cleaner)
    max.daemon = True
    max.start()

    print('Yu is cooking...')
    time.sleep(1)
    print('Yu is cooking...')
    time.sleep(1)
    print('Yu is cooking...')
    time.sleep(1)
    print('Yu is done!')
