# ui-automation [![ui-automation](https://github.com/shaikbikarsha/ui-automation/actions/workflows/build.yml/badge.svg)](https://github.com/shaikbikarsha/ui-automation/actions) [![SonarCloud](https://img.shields.io/badge/ScannedOn-SonarCloud-orange?logo=sonarcloud&ScannedOn=SonarCloud)](https://sonarcloud.io/summary/new_code?id=shaikbikarsha_ui-automation)

**Poniters used this repo**
- Selenium WebDriver 4.*.*
- Language **JAVA**
- **TestNG** to set the execution flow
- Implemented Fluent Page Object Model with Page Factory
- Maven as a build automation tool
- WebDriver Manager for auto driver executables utilization
- AShot, selenium-shutterbug - For failure scrren and webelement screenshots. 
- Video-recorder-testng for video recording
- Java faker for fake data utilization
- Snakeyaml to read yamls files for dynamic data via testng
---

### Platform Support
- Windows
- Linux
- Macintosh
---

### Browsers Supported
- Mozilla Firefox & Headless
- Google Chrome & Headless
- Opera
- Microsoft Edge Chromium

### Video feature
We have configured the video feature at global level. To store the video for a particular testcase, please use `videoFeature and videoFolder` options available in `config.properties` file. Following are options available to manage the video feature.
```sh
videoFeature=disabled                           # Default option is deisabled and it is for not to save the video
                                                # enabledALL -> To Save recorded video for All test case. Stored in "./target/Videos"
                                                # enabledFAILED -> To Save recorded video for ONLY FAILED test case. Stored in "./target/Videos"
videoFolder=./target/Videos                     # Default option is ./target/Videos. We can alter the lopcation If we want.
```
---

### Live results support with InfluxDB + Grafana
- InfluxDB version **influxdb-1.8.10-1**
- Grafana version **grafana-8.2.3**

***Note:-*** By default the execution details do store at ***localhost***. Can access the live reports [here](http://localhost:3000/d/M2A3v37Gz/automation-execution-stats?orgId=1&refresh=10s). `Username: admin, Password: Admin` Please do skip if you are getting any password reset screen.

### Visual reports
- Allure
- Sonar
