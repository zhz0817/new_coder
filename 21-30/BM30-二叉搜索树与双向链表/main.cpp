#include <bits/stdc++.h>
using namespace std;

#define FOR_INC(i, start, end) for (int i = start; i < end; ++i)
#define FOR_DEC(i, start, end) for (int i = start; i > end; --i)
#define FOR_INC_EQUAL(i, start, end) for (int i = start; i <= end; ++i)
#define FOR_DEC_EQUAL(i, start, end) for (int i = start; i >= end; --i)

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:

    void dfs(TreeNode* root,vector<TreeNode*>& vector1){
        if(root == nullptr){
            return;
        }
        dfs(root->left,vector1);
        vector1.emplace_back(root);
        dfs(root->right,vector1);
    }
    TreeNode* Convert(TreeNode* pRootOfTree) {
        if(pRootOfTree == nullptr){
            return nullptr;
        }
        vector<TreeNode*> vector1;
        dfs(pRootOfTree,vector1);
        for(int i=1;i<vector1.size()-1;i++){
            vector1[i]->left = vector1[i-1];
            vector1[i]->right = vector1[i+1];
        }
        vector1[0]->left = nullptr;
        vector1[vector1.size()-1]->right = nullptr;
        if(vector1.size()>1){
            vector1[0]->right = vector1[1];
            vector1[vector1.size()-1]->left=vector1[vector1.size()-2];
        }
        return vector1[0];
    }
};


int main()
{
//    Solution s;
//    vector<int> nums{1,2,3,4,5,6,7,0};
//    s.InversePairs(nums);
    return 0;
}