#!/usr/bin/env python3
""" Two shoppers adding items to a shared notepad """

import threading

garlic_count = 0
pencil = threading.Lock() #DEFINE MUTEX

def shopper():
    global garlic_count
    pencil.acquire() #BLOCK/WAIT = ONLY ONE THREAD CAN CONTINUE THE PROCESS
    for i in range(10_000_000):
        print(threading.current_thread().getName(), "is working...")
        garlic_count += 1

    pencil.release() #PUBLISH

if __name__ == '__main__':
    barron = threading.Thread(target=shopper)
    olivia = threading.Thread(target=shopper)
    barron.start()
    olivia.start()
    barron.join()
    olivia.join()
    print('We should buy', garlic_count, 'garlic.')
