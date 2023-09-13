![logo](https://github.com/devloping-country/mega-admin/assets/132139751/ad19ceec-3edd-40c7-a309-74b72c8020c0)
## 🏃🏃🏃🏃🏃 멤버

<table>
<tr>
    <td align="center">
    <a href="https://github.com/kimub">
    <img src="https://avatars.githubusercontent.com/u/132139751?v=4" width="100px;" alt="kimub"/>         
    <br /><b>kimub</b><br>
    </a>
    </td>
    <td align="center">
    <a href="https://github.com/chomy12">
    <img src="https://avatars.githubusercontent.com/u/136536632?v=4" width="100px;" alt="chomy12"/>         
    <br /><b>chomy12</b><br>
    </a>
    </td>
    <td align="center">
    <a href="https://github.com/shshe22">
    <img src="https://avatars.githubusercontent.com/u/136536558?v=4" width="100px;" alt="shshe22"/>         
    <br /><b>shshe22</b><br>
    </a>
    </td>
    <td align="center">
    <a href="https://github.com/rubberramen">
    <img src="https://avatars.githubusercontent.com/u/96553431?v=4" width="100px;" alt="rubberramen"/>         
    <br /><b>rubberramen</b><br>
    </a>
    </td>
    <td align="center">
    <a href="https://github.com/CDDcookie">
    <img src="https://avatars.githubusercontent.com/u/131220863?v=4" width="100px;" alt="CDDcookie"/>         
    <br /><b>CDDcookie</b><br>
    </a>
    </td>
</tr>
</table>

## 🙋🏼 소통 규칙
* 매일 아침 15분 정도의 회의를 통해 당일 어떤 업무를 할 것인지 어떤 이슈가 발생하였는지 말하는 시간을 가진다.
* 이슈가 발생하였을때 30분 동안 혼자 생각해보는 시간을 가진다. 만약 30분 내에 해결하지 못하면 팀원들에게 이슈를 공유한다.
* 말하기 전에는 한번 생각해보는 시간을 가진다.

## 💻 코드 관리 규칙
1. 커밋 규칙에 맞게 커밋을 작성한다.
2. feature-something 브랜치에서 master 브랜치에 병합할 때는 pull request를 사용한다.
3. pull request의 내용은 `close #이슈번호, #이슈번호`를 작성하여 이슈를 자동으로 닫을 수 있게 작성한다.
3. 팀장이 pull request를 확인하면 pull request를 올린 인원이 직접 병합한다.

## 📒 커밋 규칙

| 타입     | 설명                                                                               |
| -------- | ---------------------------------------------------------------------------------- |
| feat     | 새로운 기능 추가                                                                   |
| fix      | 버그 수정                                                                          |
| refactor | 리팩토링                                                                           |
| design   | CSS 등 사용자 UI 디자인 변경                                                       |
| comment  | 필요한 주석 추가 및 변경                                                           |
| style    | 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우                                  |
| test     | 테스트(테스트 코드 추가, 수정, 삭제, 비즈니스 로직에 변경이 없는 경우)             |
| docs     | 문서 수정                                                                          |
| chore    | 위에 걸리지 않는 기타 변경사항(빌드 스크립트 수정, assets image, 패키지 매니저 등) |
| init     | 프로젝트 초기 생성                                                                 |
| rename   | 파일 혹은 폴더명 수정하거나 옮기는 경우                                            |
| remove   | 파일을 삭제하는 작업만 수행하는 경우                                               |

## 📝 커밋 템플릿 등록 방법
```bash
git config --local commit.template .gitmessage.txt
```


## 🚩 코드 관련
### 실행 방법
1. [src]-[main]-[resources]의 jdpc.properties 파일의 url, user, password, driver를 본인 환경에 맞게 변경
2. 본인 MySQL에서 [src]-[main]-[resources]의 sampleQuery.sql 명령문 실행

### 도메인 적용 확인
- http://localhost:8080/{도메인}/test.do

### sample 도메인
- 현재 sample 도메인이 service layer 적옹되어 있으니 참조

### 로그
- @Slf4j, log.info("test = {}", "hello world")
  
