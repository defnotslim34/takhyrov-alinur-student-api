#!/bin/bash
# Push all branches and tags to GitHub for Alinur Takhyrov (defnotslim34)
echo "Configuring GitHub origin..."
git remote set-url origin https://github.com/defnotslim34/takhyrov-alinur-student-api.git

echo "Pushing main branch..."
git push -u origin main

echo "Pushing feature branches..."
git push origin feature/takhyrov-alinur-crud
git push origin feature/takhyrov-alinur-documentation

echo "Pushing tags..."
git push origin --tags

echo "All branches and tags pushed successfully to https://github.com/defnotslim34/takhyrov-alinur-student-api!"
