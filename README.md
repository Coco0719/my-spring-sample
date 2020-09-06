# 스프링 부트 샘플 프로젝트 저장소

## 1. 기본 프로세스

### 1-1. 이슈 라벨 및 이슈 생성

- 이슈 타입
  - new task: 신규 문서 | 샘플 프로젝트
  - update task: 기존 문서 | 샘플 프로젝트 내용 업데이트  
- 작업 진행 상태
  - todo: 앞으로 수행 할 작업
  - in progress: 진행중인 작업
  - completed: 완료된 작업
- 이슈 생성
  - 각 이슈 마다 이슈 타입과 작업 진행 상태 라벨을 사용하여 이슈의 상태를 표현
    - ex)
      - todo + new task: 신규 프로젝트 + 앞으로 진행 할 작업
      - in progress + new task: 신규 프로젝트 + 현재 진행 중인 작업
      - completed + new task: 신규 프로젝트 + 완료된 작업 

### 1-2. 브랜치 생성

- master 브랜치에서 분기하여 신규 브랜치 생성
- 브랜치 네이밍: {issue-type}/{issue-number}
  - ex)
    - new-task/3
    - update-task/7

### 1-3. Commit & PullRequest & Merge

- Commit 메시지 규칙
  - 신규 프로젝트 예시: Add spring-profile-sample, Add spring-rest-docs-sample
  - 기존 프로젝트 수정 예시: Update spring-profile-sample, Update spring-rest-docs-sample
  - 신규 문서 예시: Add {document-name}
  - 기존 문서 수정 예시: Update {document-name}
- PullRequest
  - Master 브랜치로 PR
  - PR 네이밍: [{issue-number}] {commit-message-title}
  - PR 내용: * resolved: {issue-number(종료 시킬 이슈)}
- Merge 
  - Squash and Merge 사용하여 PR 종료
  - Squash and Merge: {issue-number} {commit-message-title} {pull-request-number} 

---
## 2. 샘플 프로젝트 생성 규칙
- 저장소의 root(my-spring-sample) 하위에 프로젝트 폴더 생성
  - ex) rest-docs, profile
- IntelliJ 스프링 이니셜라이저를 사용하여 프로젝트 생성
  - Gradle or Maven
  - group: my.spring
  - artifact: sample
  - project-name-example: rest-docs, profile...
  - 프로젝트 생성 후 MainApplication.java 클래스 명 변경 
    - {project-name}SampleApplication.java
    - ex) RestDocsSampleApplication.java, ProfileSampleApplication.java

---
## 3. 샘플 프로젝트 목록

| 프로젝트                                                                                                                                       |                                  설명                                  |
| ---------------------------------------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------: |
| [`Project`](link)                                                                                                                              |            <div style="text-align: left">Description</div>             |
| [`RestDocs`](https://github.com/Coco0719/my-spring-sample/blob/master/rest-docs/src/main/java/my/spring/sample/RestDocsSampleApplication.java) |      <div style="text-align: left"> RestDocs 예제 프로젝트</div>       |
| [`Profile`](https://github.com/Coco0719/my-spring-sample/blob/master/profile/src/main/java/my/spring/sample/ProfileSampleApplication.java)     | <div style="text-align: left">Profile & Properties 예제 프로젝트</div> |
