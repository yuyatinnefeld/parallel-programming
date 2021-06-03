#!/usr/bin/env python3
""" Two shoppers adding items to a shared notepad """

import threading

garlic_count = 0
pencil = threading.Lock()

def shopper():
    global garlic_count
    for i in range(10_000_000):
        pencil.acquire()
        print(threading.current_thread().getName(), "is working...")
        garlic_count += 1
        pencil.release()

if __name__ == '__main__':
    barron = threading.Thread(target=shopper)
    olivia = threading.Thread(target=shopper)
    barron.start()
    olivia.start()
    barron.join()
    olivia.join()
    print('We should buy', garlic_count, 'garlic.')
