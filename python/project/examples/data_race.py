#!/usr/bin/env python3
""" Two shoppers adding items to a shared notepad """

import threading

garlic_count = 0

def small_shopper():
    global garlic_count
    for i in range(100):
        garlic_count += 1

def shopper():
    global garlic_count
    for i in range(10_000_000):
        garlic_count += 1


if __name__ == '__main__':

    s1 = threading.Thread(target=small_shopper)
    s2 = threading.Thread(target=small_shopper())
    s1.start()
    s2.start()
    s1.join()
    s2.join()
    print("200 expected: 2 Threads x 100 garlic")
    print('We should buy', garlic_count, 'garlic.')


    barron = threading.Thread(target=shopper)
    olivia = threading.Thread(target=shopper)
    barron.start()
    olivia.start()
    barron.join()
    olivia.join()
    print("20_000_000 expected: 2 Threads x 10_000_000 garlic")
    print('We should buy', garlic_count, 'garlic.')
    print("problem reason => Data race")


    print("garlic_count +=1 => read val -> modify val -> write val")