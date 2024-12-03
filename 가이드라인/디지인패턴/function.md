1. function Enum을 생성한다.
2. Main과 function별 컨트롤러를 생성한다.
4. function에 getFunctionEnum을 메서드를 작성한다.
5. Main에서 입력값을 Enum으로 생성하여 기능별 컨트롤러를 실행시킨다.
---
##### Function Enum
```java
public enum Function {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_PRINT("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String value;
    private final String description;

    Function(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Function find(String value) {
        for (Function f : values()) {
            if (f.value.equals(value)) {
                return f;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 기능입니다.");
    }

    @Override
    public String toString() {
        return String.format("%s. %s", value, description);
    }
}
```

##### MainController
- Function 컨트롤러에서 필요한 서비스, 레퍼지토리, 객체를 생성자에서 의존성을 주입한다.
- 전역에서 사용햐야하고, 동일하게 관리되어야하는 데이터는 싱글톤으로 선언한다.
```java
public class MainController {
    private final MatchingController matchingController;
    private final PairMatchingPrintController printController;
    private final PairMatchingDeleteController deleteController;

    public MainController() {
        PairMatchingHistory pairMatchingHistory = new PairMatchingHistory();
        this.matchingController = new MatchingController(new MatchingService(pairMatchingHistory));
        this.printController = new PairMatchingPrintController(new PairResultPrintService(pairMatchingHistory));
        this.deleteController = new PairMatchingDeleteController(new PairResultDeleteService(pairMatchingHistory));
    }

    public void run() {
        while (true) {
            Output.printFunction();
            Function type = inputfunction(); //입력을 Enum 변수로 변경한다.
            if (type.equals(Function.QUIT)) {
                break;
            }
            function(type);
        }
    }

    private void function(Function type) {
        if (matchingController.getFunctionType().equals(type)) {
            matchingController.run();
        } else if (printController.getFunctionType().equals(type)) {
            printController.run();
        } else if (deleteController.getFunctionType().equals(type)) {
            deleteController.run();
        }
    }

    private Function inputfunction() {
        while (true) {
            try {
                return Function.find(Input.inputFunctionType());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
```

##### FunctionController
- 기능에 필요한 Service를 따로 설계하여 선언한다.
```java
public class PairMatchingPrintController {
    private final PairResultPrintService printService;

    public PairMatchingPrintController(PairResultPrintService printService) {
        this.printService = printService;
    }

    public void run() {
        Output.printLevelMissionList();
        while (true) {
            try {
                PairMatchingResult pairResult = printService.printMatching(inputPairResult());
                Output.printPairMatchingResult(pairResult);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    public InputMissionDto inputPairResult() {
        return InputMissionParser.parse(Input.inputPairMissionInfo());
    }

    public Function getFunctionType() {
        return Function.PAIR_PRINT;
    }

}
```

##### Function 출력
- Enum안에 toString을 정의한다.
```java
    public static void printFunction() {
        for (Function function : Function.values()) {
            System.out.println(function);
        }
    }
```