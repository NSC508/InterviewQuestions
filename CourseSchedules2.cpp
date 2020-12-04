#include <vector>
#include <queue>
#include <unordered_set>
using namespace std;


vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
    //loop through the pre reqs,
    vector<unordered_set<int>> parents(numCourses);
    vector<unordered_set<int>> children(numCourses);
    queue<int> orderToLoop;
    vector<int> answer;
    for (auto &i : prerequisites) {
        //vector [child, parent]
        //add all the parents to a parent vector, 
        parents[i[0]].insert(i[1]);
        //add children to child vector  
        children[i[1]].insert(i[0]); 
    }
    //loop through the parents
    for (int i = 0; i < numCourses; i++) {
        //add all that have 0 size into the queue
        if (parents[i].empty()) {
            orderToLoop.push(i);
        }
    }
    while (!orderToLoop.empty()) {
        for (auto &c: children[orderToLoop.front()]) {
            //remove the front from the set at parent[c]
            parents[c].erase(orderToLoop.front());
            if (parents[c].empty()) {
                orderToLoop.push(c);
            }
        }
        answer.push_back(orderToLoop.front());
        orderToLoop.pop();
    }
    if (answer.size() != numCourses) {
        answer.clear();
    }
    return answer;
};
