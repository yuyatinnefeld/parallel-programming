from concurrent.futures import ThreadPoolExecutor
import time


def func_1():
    for count in range(3):
        time.sleep(2)
        print(f"func_1 | process {count}")
    return 'func1 result'

def func_2(x, y):
    for count in range(3):
        time.sleep(1)
        print(f"func_2 | process {count} | {x} - {y}")
    return 'func2 result'

def main():
    print("program start")
    with ThreadPoolExecutor(max_workers=2) as executor:
        future_1 = executor.submit(func_1)
        future_2 = executor.submit(func_2, 'hello', 'world')
        
    result_1 = future_1.result()
    result_2 = future_2.result()
    
    print("result of func_1:", result_1)
    print("result of func_2:", result_2)

    print("program end")

if __name__ == '__main__':
    main()