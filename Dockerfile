FROM openjdk:12-alpine

WORKDIR /challenges

RUN apk add git
RUN git clone https://github.com/DMarlon/olistly-challenges.git .
RUN ./gradlew build
RUN mv build/libs/challenges-0.0.1-OLY.jar challenges.jar
RUN ln -s build/reports/tests/test/index.html test-report.html

CMD [\
  "java",\
  "-jar",\
  "challenges.jar"\
]
