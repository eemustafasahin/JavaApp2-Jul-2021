package org.csystem.util.collection.dlinkedlist;

import org.csystem.util.collection.util.collection.DLinkedList;
import org.csystem.util.io.file.FileUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Test_deleteItemTail {
    private static final String ms_expectedBase = "delete_item_tail_expected";
    private static final String ms_actualBase = "delete_item_head_actual";
    private static int ms_count;
    private final List<String> m_list;
    private DLinkedList<String> m_testList;

    private void saveExpected()
    {
        try (var bw = Files.newBufferedWriter(Path.of(ms_expectedBase + "-" + ms_count + ".txt"))) {
            m_list.remove(m_list.size() - 1);
            for (var str : m_list)
                bw.write(str + "\r\n");

            bw.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveActual(DLinkedList<String> list)
    {
        try (var bw = Files.newBufferedWriter(Path.of(ms_actualBase + "-" + ms_count + ".txt"))) {
            list.walk(str -> {
                try {
                    bw.write(str + "\r\n");
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        var list = new ArrayList<List<String>>();

        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami"); add("ayşe");}});
        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami");}});
        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami"); add("ayşe"); add("fatma");}});

        ms_count = list.size();

        return list;
    }

    @Before
    public void setUp()
    {
        m_testList = new DLinkedList<>();

        for (var str : m_list)
            m_testList.addItemTail(str);

        Assert.assertEquals(m_list.size(), m_testList.size());

        --ms_count;
    }

    public Test_deleteItemTail(List<String> list)
    {
        m_list = list;
    }

    @Test
    public void test_deleteItemTail() throws IOException
    {
        m_testList.deleteItemTail();
        saveActual(m_testList);
        saveExpected();

        Assert.assertTrue(FileUtil.areSame(ms_expectedBase + "-" + ms_count + ".txt", ms_actualBase + "-" + ms_count + ".txt"));
    }
}
