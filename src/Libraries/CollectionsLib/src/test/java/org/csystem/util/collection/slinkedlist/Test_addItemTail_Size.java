package org.csystem.util.collection.slinkedlist;

import org.csystem.collection.SLinkedList;
import org.csystem.util.collection.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Test_addItemTail_Size {
    private final List<String> m_list;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    public Test_addItemTail_Size(List<String> list)
    {
        m_list = list;
    }

    @Test
    public void test_addItemTailSize()
    {
        var list = new SLinkedList<String>();

        m_list.forEach(list::addItemTail);

        Assert.assertEquals(m_list.size(), list.size());
    }
}
