import java.util.Scanner;

/**
 * 애플리케이션 메인 실행 로직
 * 명령어 처리 및 프로그램 흐름 관리
 */
public class App {
    private Scanner scanner;
    private boolean running;

    public App() {
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    /**
     * 메인 실행 루프
     */
    public void run() {
        System.out.println("프로그램이 시작되었습니다.");

        // DB 연결 테스트
        if (!DBUtil.testConnection()) {
            System.out.println("데이터베이스 연결에 실패했습니다. 설정을 확인해주세요.");
            System.out.println("db.properties 파일의 DB 설정을 확인하고, MySQL 서버가 실행 중인지 확인해주세요.");
            return;
        }

        System.out.println("데이터베이스 연결 성공!");
        System.out.println("'help'를 입력하면 명령어 목록을 확인할 수 있습니다.");

        while (running) {
            System.out.print("\n명령어: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            Rq rq = new Rq(input);
            processCommand(rq);
        }

        scanner.close();
    }

    /**
     * 명령어 처리
     */
    private void processCommand(Rq rq) {
        String commandName = rq.getCommand();

        switch (commandName) {
            case "exit":
                handleExit();
                break;
            case "help":
                showHelp();
                break;
            default:
                System.out.println("알 수 없는 명령어입니다. 'help'를 입력해주세요.");
                break;
        }
    }

    /**
     * 프로그램 종료 처리
     */
    private void handleExit() {
        System.out.println("프로그램을 종료합니다.");
        running = false;
    }

    /**
     * 도움말 출력
     */
    private void showHelp() {
        System.out.println("\n=== 사용 가능한 명령어 ===");
        System.out.println("help                 : 도움말");
        System.out.println("exit                 : 종료\n");
    }
}
