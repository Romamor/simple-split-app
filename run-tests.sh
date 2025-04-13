#!/bin/bash

echo "Running backend tests..."
cd backend && ./gradlew test && cd ..

echo "Running Telegram bot tests..."
cd telegram-bot && ./gradlew test && cd ..

echo "Running Android tests..."
cd android-app && ./gradlew testDebugUnitTest && cd ..
