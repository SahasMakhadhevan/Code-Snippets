make;
echo "Running Tester:";
./tester;

echo "Running Simple Input:"
./tester -w traces/simple-input >simple-output; 
if diff -q simple-output traces/simple-expected-output; then
echo "Passed!"
else
echo "Failed."
fi
rm simple-output;

echo "Running Random Input:"
./tester -w traces/random-input >random-output; 
if diff -q random-output traces/random-expected-output; then
echo "Passed!"
else
echo "Failed."
fi
rm random-output;

echo "Running Linear Input:"
./tester -w traces/linear-input >linear-output; 
if diff -q linear-output traces/linear-expected-output; then
echo "Passed!"
else
echo "Failed."
fi
rm linear-output;

echo "All Test Cases Run."
