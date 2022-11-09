make;
echo "Running Tester:";
./tester;

COUNTER=0;
echo "Running Simple Input w/ 1024 cache:"
./tester -w traces/simple-input -s 1024 >simple-output;
if diff -q simple-output traces/simple-expected-output; then
echo "Passed!"
COUNTER=$((COUNTER+1));
else
echo "Failed."
fi
rm simple-output;

echo "Running Simple Input w/ 4096 cache:"
./tester -w traces/simple-input -s 4096 >simple-output;
if diff -q simple-output traces/simple-expected-output; then
echo "Passed!"
COUNTER=$((COUNTER+1));
else
echo "Failed."
fi
rm simple-output;

echo "Running Random Input w/ 1024 cache:"
./tester -w traces/random-input -s 1024 >random-output; 
if diff -q random-output traces/random-expected-output; then
echo "Passed!"
COUNTER=$((COUNTER+1));
else
echo "Failed."
fi
rm random-output;

echo "Running Random Input w/ 4096 cache:"
./tester -w traces/random-input -s 4096 >random-output; 
if diff -q random-output traces/random-expected-output; then
echo "Passed!"
COUNTER=$((COUNTER+1));
else
echo "Failed."
fi
rm random-output;

echo "Running Linear Input w/ 1024 cache:"
./tester -w traces/linear-input -s 1024 >linear-output; 
if diff -q linear-output traces/linear-expected-output; then
echo "Passed!"
COUNTER=$((COUNTER+1));
else
echo "Failed."
fi
rm linear-output;

echo "Running Linear Input w/ 4096 cache:"
./tester -w traces/linear-input -s 4096 >linear-output; 
if diff -q linear-output traces/linear-expected-output; then
echo "Passed!"
COUNTER=$((COUNTER+1));
else
echo "Failed."
fi
rm linear-output;

echo "All Test Cases Run."
echo "Passed $COUNTER/6 Test Cases."
