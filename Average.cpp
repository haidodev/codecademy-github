#include <iostream>

double calculateAverage(const int arr[], int size) {
    int sum = 0;
    for (int i = 0; i < size; ++i) {
        sum += arr[i];
    }
    return static_cast<double>(sum) / size;
}

int main() {
    const int arr[] = {5, 10, 15, 20, 25};
    int size = sizeof(arr) / sizeof(arr[0]);

    double average = calculateAverage(arr, size);

    std::cout << "Average: " << average << std::endl;

    return 0;
}
