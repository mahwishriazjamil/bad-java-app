/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details
 *
 * @author Nick Sanidas
 * @created 2015
 */
package org.owasp.benchmark.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Thing2 implements ThingInterface {

    @Override
    public String doSomething(String i) {
        if (i == null) return "";
        String r = new StringBuilder(i).toString();
        return r;
    }

    // Violates S112: Generic exceptions should not be thrown
    public String processInput(String input) throws Exception {
        if (input == null) {
            throw new Exception("Input must not be null");
        }
        return input.trim();
    }

    // Violates S1168: Return empty collection instead of null
    public List<String> getItems(String category) {
        if (category == null) {
            return null;
        }
        return new ArrayList<>();
    }

    // Violates S2095: Resources should be closed
    public int countBytes(String filePath) throws IOException {
        InputStream stream = new FileInputStream(filePath);
        int count = 0;
        while (stream.read() != -1) {
            count++;
        }
        return count;
    }
}
