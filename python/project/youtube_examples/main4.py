from concurrent.futures import ThreadPoolExecutor
import time


def func_1(x):
    for count in range(3):
        time.sleep(2)
        print(f"func_1 | process {count} - {x}")
    return 'func1 result'


def main():
    print("program start")
    with ThreadPoolExecutor(max_workers=4) as executor:
        executor.map(func_1, ['A', 'B', 'C', 'D'])

    print("program end")

if __name__ == '__main__':
    main()