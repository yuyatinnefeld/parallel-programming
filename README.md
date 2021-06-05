<h1 align="center"> Parallel Programing (Python / Java)</h1> <br>
<h2>🚀 Table of Contents 🚀 </h2>

- [About](#about)
- [Info](#info)
- [Concept](#concept)
- [Setup](#setup)


## ⚡ About ⚡ 
In this project you can learn parallel programming (Python & Java) to execute multiple instructions simultaneously, increases the overall processing throughput
This can help to writing faster and more efficient applications. 

## Info
- https://en.wikipedia.org/wiki/Scheduling_(computing)

## Concept

### Flynn's Taxonomy

![GitHub Logo](/images/flynns_taxonomy.png)
- SISD (Single Instruction, Single Data)
- SIMD (Single Instruction, Multiple Data)
- MISD (Multiple Instruction, Single Data)
- MIMD (Multiple Instruction, Multiple Data)
  
![GitHub Logo](/images/flynns_taxonomy2.png)


### Parallel Programming Architecture
- SPMD (Simple Program, Multiple Data)
- MPMD (Multiple Program, Multiple Data) => Manager & Worker Node

## Memory
### Shared Memory (all CPUs access the same Memory with the global address space)
    - UMA (Uniform Memory Access)
    - NUMA (Non-Uniform Memory Access)


![GitHub Logo](/images/uma.png)

![GitHub Logo](/images/numa.png)

### Distributed Memory (all CPUs)
    - Scalable
    - Linear
    - Fixed

![GitHub Logo](/images/dsm.png)

## Threads and Process
Python
> example code: project/examples/multiple_threads.py

> example code: project/examples/multiple_processes.py


### Threads
- Thread is an execution unit = part of a process.
- Threads are "lightweight" - require less overhead to create and terminate
- OS can switch between threads faster than processes

### Inter-process Communication (IPC)
- Socket and pipes
- Shared Memory
- RPC

### Concurrency

![GitHub Logo](/images/concurrency.png)
- Application only has ONE CPU and makes progress on multiple tasks, but not same time

### Parallel Execution

![GitHub Logo](/images/parallel_execution.png)
- Application has MANY CPUs and makes progress on multiple task at once

### Parallelism

![GitHub Logo](/images/parallelism.png)
- Application splits its tasks up into smaller subtasks which can be processed in parallel, for instance on multiple CPUs at the exact same time. 
- Thus, parallelism does not refer to the same execution model as parallel concurrent execution - even if they may look similar on the surface.

### Parallel Hardware
- Multi-Core Processors
- GPU
- Computer Cluster


### GIL (Global interpreter lock)
- GIL is a mutex (mutual exclusion) that allows ONLY ONE thread to hold the control of the Python interpreter
- only one thread can be in a state of execution at any point in time.
- This mutex is necessary mainly because CPython's memory management is not thread-safe.
- By I/O Bounced Application GIL is NOT a bottleneck
- BY CPU Bounced Application GIL can negatively impact performance

### Scheduling

Python
> example code: project/examples/execution_scheduling.py

Java
> example code: com.parallel_programming.ExecutionSchedulingDemo.java

#### Scheduling Algorithms
- First come, first served
- Shortest job next
- Priority
- Shortest remaining time
- Round-robin
- Multiple-level queues

#### Scheduling Goals
- Maximize throughput
- Maximize fairness
- Minimize wait time
- Minimize latency

### Lifecycle of Thread

![GitHub Logo](/images/lifecyle_of_thread.png)

Thread Status
Python: OBJECT.is_alive() => false, true
Java: OBJECT.getState() => NEW, RUNNABLE, BLOCK, WAITING, TIMED_WAITING, TERMINATED

Thread Priority
1 = low, 10 = high

Create Thread in JAVA
- create thread class which extends Thread => Thread olivia = new ChefOlivia();
- implement the runnable interface => Thread olivia = new Thread(new ChefOlivia1());

Python
> example code: project/examples/thread_lifecycle.py

Java
> example code: com.parallel_programming.ThreadLifecycleDemo.java
> example code: com.parallel_programming.RunnableDemo.java

Thread vs. Runnable (Java)
Extending Thread class
- Cannot extend additional classes
- each instance is a separate object

Implementing Runnable interface (more flexible)
- can implement other interfaces and extend another class
- multiple threads can share a single runnable object

### Daemon (Background) Thread

- Daemon thread is a low priority thread (in context of JVM) that runs in background to perform tasks such as garbage collection (gc) etc.
- When a new thread is created it inherits the daemon status of its parent.
- they do not prevent the JVM from exiting (even if the daemon thread itself is running) when all the user threads (non-daemon threads) finish their execution.
- We do not care whether Daemon thread is running or not
- If the daemon thread is running, it does shutdown itself later
- Python => by default non-daemon
- Python => set the daemon property to change status before starting thread

Python:
> example code: project/examples/daemon_threads.py

Java:
> example code: com.parallel_programming.DaemonThreadDemo.java

## Mutex
### Data Race
Python:
> example code: project/examples/data_race.py

Java:
> example code: com.parallel_programming.DataRaceDemo.java


- Data Race Problem => two or more concurrent threads access the same memory location and reading, changing & overwriting wrong information
- Detecting Data Race is very hard
  
### Mutex
Python:
> example code: project/examples/mutex0.py


> example code: project/examples/mutex1.py

Java:
> example code: com.parallel_programming.MutexDemo0.java

Solution
> example code: com.parallel_programming.MutexDemo1.java

Solution with AtomicInteger
> example code: com.parallel_programming.MutexDemo2.java

Solution with SynchronizedMethodDemo
> example code: com.parallel_programming.SynchronizedMethodDemo.java

Synchronized vs. Locks by Java:
- Synchronized => easier to implement and prevents many pitfalls of locks
- Locks => provide more flexibility to implement certain algorithms

- Mutex (Mutual Exclution) is used for the concurrency control to avoid Data Race
- By Mutex can only one thread or process can possess at a time
- Limits access to critical section (ex. data storing)
- atomic operations = execute as a single action, relative to other threads
- cannot be interrupted by other concurrent threads
- acquiring a lock = if lock is already taken, block/wait for it to be available
- keep protected sections of code AS SHORT AS POSSIBLE

## Locks
Python:
> example code: project/examples/reentrant_lock.py

Java:
> example code: com.parallel_programming.ReentrantLock.java

- Deadlock => all processes and threads are unable to continue executing because they are waiting for another members
- Reentrant Mutex
    - can be locked multiple time by the same thread
    - must be unlocked as many times as it was locked
- Common Terms
    - Reentrant mutex
    - Reentrant lock
    - Recursive mutex
    - Recursive lock
    
### Lock vs. RLock / ReentrantLock
- Lock can be released by a different thread than was used to acquire it
- RLock must be released by the same thread that acquired it

### Try lock
- Non-blocking lock/acquire method for mutex
- if the mutex is available, lock it and return TRUE
- if the mutex is not available, immediately return FALSE
- used mostly for the multiple threads which have multiple tasks

Python:
> example code: project/examples/nonblocking_acquire0.py

> example code: project/examples/nonblocking_acquire1.py
 
Java:
> example code: com.parallel_programming.TryLockDemo0.java

> example code: com.parallel_programming.TryLockDemo1.java


### Reader-Writer Lock / shared_mutex
- SHARED READ => multiple threads at once
- EXCLUSIVE WRITE => only one thread at a time

Python:
> example code: project/examples/readwrite_lock0.py

> example code: project/examples/readwrite_lock1.py

Java:
> example code: com.parallel_programming.TryLockDemo0.java

> example code: com.parallel_programming.TryLockDemo1.java


```bash
pip install readerwriterlock
```

#### RWLock
marker = rwlock.RWLockFair()
- fair priority for reader/writers
- gen_rlock() generates a reader lock object
- gen_wlock() generates a writer lock object

Java:
ReentrantReadWriteLock.ReadLock
ReentrantReadWriteLock.WriteLock


## Liveness (how to avoid Deadlock)
- Liveness guarantees are important properties in operating systems and distributed systems
- Liveness requires a system to make progress despite the fact that its concurrently executing components ("processes") may have to "take turns" in critical sections, parts of the program that cannot be simultaneously run by multiple processes
- Lock Ordering
  - ensure locks are always taken in the same order by any thread
  - example code: project/examples/deadlock1.py
- Lock Timeout
  - Put a timeout on lock attempts
  
Python:
> example code: project/examples/deadlock0.py

Java:
> example code: com.parallel_programming.DeadlockDemo.java


  
### Abandoned Lock
Python:
> example code: project/examples/abandoned_lock0.py

> example code: project/examples/abandoned_lock1.py

> example code: project/examples/abandoned_lock2.py

Java:
> example code: com.parallel_programming.AbandonedLockDemo.java

> example code: com.parallel_programming.AbandonedLockDemo.java


### Starvation Lock
Python:
> example code: project/examples/starvation.py

Java:
> example code: com.parallel_programming.Starvation.java




