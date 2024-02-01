
import  java.util.*;
import java.util.LinkedList;

class Process {
    int processID;
    int arrivalTime;
    int burstTime;
    int priority;
    int remainingTime;

    Process(int processID, int arrivalTime, int burstTime, int priority) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }
}

public class PrioritySchedulingRR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quantum time (q): ");
        int quantum = scanner.nextInt();

        List<Process> processes = new ArrayList<>();
        System.out.println("Enter process ID, arrival time, burst time, and priority (0 0 0 0 to end input): ");
        while (true) {
            int processID = scanner.nextInt();
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            int priority = scanner.nextInt();
            if (processID == 0 && arrivalTime == 0 && burstTime == 0 && priority == 0) {
                break;
            }
            processes.add(new Process(processID, arrivalTime, burstTime, priority));
        }
        scanner.close();

        // Sort processes based on arrival time and priority
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        processes.sort(Comparator.comparingInt(p -> p.priority));

        // Queue for ready processes
        Queue<Process> readyQueue = new LinkedList<>();
        

        // Gantt Chart
        StringBuilder ganttChart = new StringBuilder();
        ganttChart.append("0");

        // Calculate Turnaround Time, Response Time, Waiting Time, and Gantt Chart
        int currentTime = 0;
        int totalTurnaroundTime = 0;
        int totalResponseTime = 0;
        int totalWaitingTime = 0;

        while (!processes.isEmpty() || !readyQueue.isEmpty()) {
            if (!processes.isEmpty() && processes.get(0).arrivalTime <= currentTime) {
                readyQueue.add(processes.remove(0));
                continue;
            }

            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();
                ganttChart.append("-p").append(currentProcess.processID);

                int responseTime = currentTime - currentProcess.arrivalTime;
                totalResponseTime += responseTime;

                int quantumTime = Math.min(quantum, currentProcess.remainingTime);
                currentProcess.remainingTime -= quantumTime;
                currentTime += quantumTime;

                if (currentProcess.remainingTime > 0) {
                    readyQueue.add(currentProcess);
                } else {
                    int turnaroundTime = currentTime - currentProcess.arrivalTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalWaitingTime += turnaroundTime - currentProcess.burstTime;
                }
            } else {
                currentTime++;
                ganttChart.append("-");
            }
        }

        // Calculate averages
        int totalProcesses = processes.size();
        double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;
        double avgResponseTime = (double) totalResponseTime / totalProcesses;
        double avgWaitingTime = (double) totalWaitingTime / totalProcesses;

        // Print Gantt Chart
        System.out.println("Gantt Chart: " + ganttChart.toString());

        // Print Turnaround Time, Response Time, Waiting Time, and Averages
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        System.out.println("Average Response Time: " + avgResponseTime);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
    }
}