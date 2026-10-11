package org.example;

import java.util.List;
import org.example.dtos.CreateExpenseRequest;
import org.example.dtos.SplitRequest;
import org.example.dtos.TransactionResponse;
import org.example.enums.DebtSimplifierType;
import org.example.enums.SplitType;
import org.example.models.Group;
import org.example.models.User;
import org.example.repository.GroupRepository;
import org.example.repository.InMemoryGroupRepository;
import org.example.repository.InMemoryUserRepository;
import org.example.repository.UserRepository;
import org.example.services.BalanceSheetService;
import org.example.services.DebtSimplifierService;
import org.example.services.ExpenseService;
import org.example.services.GroupService;
import org.example.services.SplitService;
import org.example.services.SplitwiseService;
import org.example.services.UserService;

public class Main {

    static void main() {
        System.out.println(
            " ================= SPLIT WISE SYSTEM ================="
        );

        UserRepository userRepository = new InMemoryUserRepository();
        GroupRepository groupRepository = new InMemoryGroupRepository();

        UserService userService = new UserService(userRepository);
        GroupService groupService = new GroupService(groupRepository);
        SplitService splitService = new SplitService();
        ExpenseService expenseService = new ExpenseService(splitService);
        DebtSimplifierService debtSimplifierService =
            new DebtSimplifierService();
        BalanceSheetService balanceSheetService = new BalanceSheetService();

        SplitwiseService splitwise = new SplitwiseService(
            userService,
            groupService,
            expenseService,
            debtSimplifierService,
            balanceSheetService
        );

        User u1 = splitwise.createUser("Aman", "aman@gamil.com");
        User u2 = splitwise.createUser("Rohit", "rohit@gmail.com");
        User u3 = splitwise.createUser("Bob", "bob@gmail.com");
        User u4 = splitwise.createUser("Alice", "alice@gmail.com");

        List<User> members = List.of(u1, u2, u3, u4);

        Group group = splitwise.createGroup("Goa Trip", u1.getId(), members);

        List<SplitRequest> splitsAll = List.of(
            new SplitRequest(u1.getId(), 0.0),
            new SplitRequest(u2.getId(), 0.0),
            new SplitRequest(u3.getId(), 0.0),
            new SplitRequest(u4.getId(), 0.0)
        );

        List<SplitRequest> splitsU1U2U4 = List.of(
            new SplitRequest(u1.getId(), 0.0),
            new SplitRequest(u2.getId(), 0.0),
            new SplitRequest(u4.getId(), 0.0)
        );

        // Expense1. Aman pays $200 for Dinner
        splitwise.createExpense(
            group.getId(),
            new CreateExpenseRequest(
                group.getId(),
                "Dinner",
                "Dinner",
                u1.getId(),
                u1.getId(),
                200.0,
                SplitType.EQUAL,
                splitsAll
            )
        );

        // Expense2. Aman pays $600 fro BreakFast (u1,u2,u4)
        splitwise.createExpense(
            group.getId(),
            new CreateExpenseRequest(
                group.getId(),
                "BreakFast",
                "BreakFast",
                u1.getId(),
                u1.getId(),
                600.0,
                SplitType.EQUAL,
                splitsU1U2U4
            )
        );

        // Expense3. Alice pays $300 for Snacks (u1,u2,u3)

        splitwise.createExpense(
            group.getId(),
            new CreateExpenseRequest(
                group.getId(),
                "Snacks",
                "Snacks",
                u4.getId(),
                u4.getId(),
                300.0,
                SplitType.EQUAL,
                splitsU1U2U4
            )
        );

        // Show balance sheets
        splitwise.getBalanceSheetByUserId(group.getId(), u1.getId());
        splitwise.getBalanceSheetByUserId(group.getId(), u4.getId());

        // Simplify Debts
        System.out.println(
            "=========== Simplified Settlement Plan =================="
        );
        List<TransactionResponse> simplifiedTransactions =
            splitwise.simplifyDebt(group.getId(), DebtSimplifierType.BASICE);

        for (TransactionResponse t : simplifiedTransactions) {
            System.out.println(
                " User " +
                    t.userName() +
                    " should pay $ " +
                    t.amount() +
                    " to User " +
                    t.toUserName()
            );
        }
    }
}
