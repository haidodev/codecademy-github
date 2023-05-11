#include <iostream>
#include <unordered_map>
#include <vector>

std::vector<int> findMode(const std::vector<int>& arr) {
    std::unordered_map<int, int> frequencyMap;

    // Count the frequency of each element in the array
    for (int num : arr) {
        frequencyMap[num]++;
    }

    std::vector<int> modes;
    int maxFrequency = 0;

    // Find the element(s) with the maximum frequency
    for (const auto& pair : frequencyMap) {
        int num = pair.first;
        int frequency = pair.second;

        if (frequency > maxFrequency) {
            maxFrequency = frequency;
            modes = { num };
        } else if (frequency == maxFrequency) {
            modes.push_back(num);
        }
    }

    return modes;
}

int main() {
    std::vector<int> arr = { 1, 2, 2, 3, 3, 3, 4, 5, 5 };

    std::vector<int> modes = findMode(arr);

    std::cout << "Mode(s): ";
    for (int mode : modes) {
        std::cout << mode << " ";
    }
    std::cout << std::endl;

    return 0;
}
