#include <vector>
using namespace std;
int maxProfit(vector<int>& prices) {
    if (prices.empty()) {
        return 0;
    }
    int minSoFar = prices[0];
    int maxSoFar = prices[0];
    int profit = 0;
    for (int &i : prices) {
        if (i < minSoFar) {
            if (maxSoFar - minSoFar > profit) {
                profit = maxSoFar - minSoFar;
            }
            minSoFar = i;
            maxSoFar = i;
        } else if (i > maxSoFar) {
            maxSoFar = i;
        }
    }   
    return profit > maxSoFar - minSoFar ? profit : maxSoFar - minSoFar;
}