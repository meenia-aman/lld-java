package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.enums.SplitType;
import org.example.models.Group;
import org.example.models.User;
import org.example.repository.GroupRepository;
import org.example.repository.InMemoryGroupRepository;
import org.example.services.BalanceSheetService;
import org.example.services.ExpenseService;
import org.example.services.GroupService;
import org.example.services.SplitService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main() {
        System.out.println(
            " ================= SPLIT WISE SYSTEM ================="
        );

        User u1 = new User("Aman", "aman@gmail.com");
        User u2 = new User("Rohit", "rohit@gmail.com");
        User u3 = new User("Bob", "bob@gmail.com");
        User u4 = new User("Alice", "alice@gmail.com");

        GroupRepository groupRepository = new InMemoryGroupRepository();

        GroupService groupService = new GroupService(groupRepository);

        List<User> users = new ArrayList<>(List.of(u1, u2, u3, u4));

        Group group = groupService.CreateGroup("Goa Trip", u1.getId(), users);

        SplitService splitService = new SplitService();
        BalanceSheetService balanceSheetService = new BalanceSheetService();

        ExpenseService expenseService = new ExpenseService(
            groupService,
            splitService,
            balanceSheetService
        );

        List<User> e1_users = new ArrayList<>(List.of(u1, u2, u3, u4));
        List<User> e2_users = new ArrayList<>(List.of(u1, u2, u4));
        List<User> e3_users = new ArrayList<>(List.of(u1, u3, u4));

        expenseService.createExpense(
            group.getId(),
            "Dinner",
            "Dinner",
            u1.getId(),
            u1.getId(),
            200,
            SplitType.EQUAL,
            e1_users
        );

        expenseService.createExpense(
            group.getId(),
            "BreakFast",
            "Breakfast",
            u1.getId(),
            u1.getId(),
            500,
            SplitType.EQUAL,
            e2_users
        );

        expenseService.createExpense(
            group.getId(),
            "Games",
            "Games",
            u1.getId(),
            u1.getId(),
            1000,
            SplitType.EQUAL,
            e3_users
        );

        expenseService.createExpense(
            group.getId(),
            "BreakFast",
            "Breakfast",
            u4.getId(),
            u4.getId(),
            200,
            SplitType.EQUAL,
            e2_users
        );

        expenseService.createExpense(
            group.getId(),
            "Games",
            "Games",
            u4.getId(),
            u4.getId(),
            2000,
            SplitType.EQUAL,
            e3_users
        );

        expenseService.getBalanceSheetByUserId(group.getId(), u1.getId());
        // expenseService.getBalanceSheetByUserId(group.getId(), u3.getId());
        expenseService.getBalanceSheetByUserId(group.getId(), u4.getId());
    }
}
