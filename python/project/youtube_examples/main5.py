from concurrent.futures import ProcessPoolExecutor
import time


def func_1():
    for count in range(3):
        time.sleep(1)
        print(f"func_1 | process {count} ...")
    return 'func1 result'


def func_2():
    for count in range(3):
        time.sleep(2)
        print(f"func_2 | process {count} ...")
    return 'func2 result'


def func_3():
    for count in range(3):
        time.sleep(1)
        print(f"func_3 | process {count} ...")
    return 'func3 result'


def main():
    print("program start")
    with ProcessPoolExecutor(max_workers=3) as executor:
        executor.submit(func_1)
        executor.submit(func_2)
        executor.submit(func_3)

    print("program end")

if __name__ == '__main__':
    main()