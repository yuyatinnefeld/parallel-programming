from concurrent.futures import ThreadPoolExecutor
import time


def func_1():
    for count in range(3):
        time.sleep(2)
        print(f"func_1 | process {count}")
    return 'func1 done'

def func_2(x, y):
    for count in range(3):
        time.sleep(1)
        print(f"func_2 | process {count} - {x} - {y}")
    return 'func2 done'

def main():
    print("program start")
    with ThreadPoolExecutor(max_workers=2) as executor:
        executor.submit(func_1)
        executor.submit(func_2, 'hello', 'world')

    print("program end")

if __name__ == '__main__':
    main()