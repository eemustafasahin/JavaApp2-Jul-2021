package org.csystem.util.collection.dlinkedlist;

import org.csystem.collection.DLinkedList;
import org.csystem.util.collection.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Test_addItemHead_Size {
    private final List<String> m_list;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_addItemHead_Size(List<String> list)
    {
        m_list = list;
    }

    @Test
    public void test_addItemHeadSize()
    {
        var list = new DLinkedList<String>();

        for (var str : m_list)
            list.addItemHead(str);

        Assert.assertEquals(m_list.size(), list.size());
    }
}
