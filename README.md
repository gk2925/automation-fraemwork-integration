# JUnit5 sample project

## Pre-requisites for running the tests in the project

- Java must be installed on your system (JDK8 or higher)
- Maven must be installed on your system
- Python3 must be installed on your system
- Chrome browser must be installed on the system for running the tests (109 or higher)

## How to parse the test results to testrail without using any CI/CD tool

- Replace the placeholders in `trcli-config.yml` with your TestRail instance details
- Execute the commands on the script below if you would like to parse test results without any CI/CD tool

```sh
# Install TR CLI
pip install trcli

# Install test project
mvn clean compile

# Run tests
mvn clean compile test

# Upload test results to Testrail
trcli -y -c "trcli-config.yml" parse_junit -f "./target/TEST-junit-jupiter.xml"

```