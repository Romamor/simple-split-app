#!/bin/bash

echo "Running backend tests..."
cd backend && ./gradlew test && cd ..

echo "Running Android tests..."
cd android-app && ./gradlew testDebugUnitTest && cd ..
