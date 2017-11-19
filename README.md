# kemiex-test-automation-poc
Testing the feedback functionality for KEMIEX

### How to verify the solution and run the tests
- First, get a local copy of the kemiex-test-automation-poc repository from GitHub: https://github.com/LaurP/kemiex-test-automation-poc.git
- Go to: kemiex-test-automation-poc/src/test/resources/kemiex_suite .xml and set the values of the following parameters:
    - name="browser" - value can be "chrome" or "firefox" - depending on the value of this parameter, the framework will run the tests either in Chrome, either in Firefox.
    - name="localOS" - value can be "windows", "macos", or "linux" for valid test run (other values are accepted as well, but the borwser will not be correctly set and the tests will not run)
- In your IDE go to: kemiex-test-automation-poc/src/test/resources, right click on kemiex_suite .xml and select 'Run' to run the tests. Al the tests will be run (as per the current configuration)

Note1: 2 tests will fail because of 2 different bugs.
Note2: make sure you are using the correct language/module/compiler language levels in your local project before running the tests.
