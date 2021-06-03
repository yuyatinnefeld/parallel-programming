#!/usr/bin/env python3
""" Two threads cooking soup """

import threading
import time

class ChefOlivia(threading.Thread):
    def __init__(self):
        super().__init__()

    def run(self):
        print('Olivia started & waiting for sausage to thaw...')
        time.sleep(10)
        print('Olivia is done cutting sausage.')

# main thread a.k.a. Barron
if __name__ == '__main__':
    print("Yu started & requesting Olivia's help.")
    olivia = ChefOlivia()
    print('Olivia alive?', olivia.is_alive())

    print('Yu tells Olivia to start.')
    olivia.start()
    print('Olivia alive?', olivia.is_alive())

    print('Yu continues cooking soup.')
    time.sleep(2)
    print('Olivia alive?', olivia.is_alive())

    print('Yu patiently waits for Olivia to finish and join...')
    olivia.join()
    print('Olivia alive?', olivia.is_alive())

    print('Yu and Olivia are both done!')
