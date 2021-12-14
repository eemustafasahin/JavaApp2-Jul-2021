package org.csystem.util.collection.deque;

import org.csystem.collection.Deque;
import org.csystem.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Test_getItemFirst_OptionalNotEmpty {
    private final List<String> m_list;
    private Deque<String> m_deque;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    @Before
    public void setUp()
    {
        m_deque = new Deque<>();

        m_list.forEach(m_deque::addItemLast);
    }

    public Test_getItemFirst_OptionalNotEmpty(List<String> list)
    {
        m_list = list;
    }

    @Test
    public void test_getItemFirst()
    {
        Assert.assertEquals(m_list.get(0), m_deque.getItemFirst().get());
    }
}
