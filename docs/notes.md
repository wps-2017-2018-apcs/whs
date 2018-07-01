# Notes on the Minesweeper project

These are notes collected during the final project period, mostly by e-mail:

---

**On Thu, May 24, 2018 at 8:59 PM David C. Petty wrote:**

<https://help.github.com/articles/adding-organization-members-to-a-team/>

Apparently, I need to invite you all to this organization: <https://github.com/organizations/wps-2017-2018-apcs/> so please let me know your id in class tomorrow.

---

**On Sun, Jun 3, 2018 at 9:51 AM David C. Petty wrote:**

- I have prepared a [document](https://docs.google.com/document/d/1fJs_t8NVRUpM7alH4vWlWnz8H07tWdg8WJkRdo4d3Ac/) to help you with the final two APCS assignments.
- I have prepared a [document](https://docs.google.com/document/d/1xrqUS0VPWsAt0SaLzvyRNm3990nTPUp4WF4-4Tx2GaM/) to help with the final project on Github.
- I had a few questions from students. The APCS classes now belong to Mr. Stacy and you. I know you are talented and resilient enough to self-organize and finish your project. (By the way, what is it?)
- *However*, if there are grading questions, I will answer them. Mr. Stacy is not responsible for any grades in the past &mdash; just the go / no-go (A / F--) grade on your final project.
- Please cc Mr. Stacy on any APCS e-mail you send me.

Good luck. I will read any e-mail you send me, APCS-related or not. Have a great summer!

---

**On Mon, Jun 4, 2018 at 7:47 AM David C. Petty wrote:**

- Open a terminal window and `cd` to the project directory.
- Type `git pull origin master`. Did you update?
- Type `mvn package`. Did you build?
 
Have fun!
 
\- dcp

---

**On Mon, Jun 4, 2018 at 10:34 AM David C. Petty wrote:**

I don't know what project you are using. You need to use this project: <https://github.com/wps-2017-2018-apcs/whs>

---

**On Mon, Jun 4, 2018 at 11:00 AM David C. Petty wrote:**

OH! I hadn't enabled write permissions (*i.e.* `git push origin master`) for this organization / repository. I just did. Please let me know if you can now push committed changes.

\- dcp

p.s. Let me know when you are having issues like this. Are there any others?

---

**On Tue, Jun 5, 2018 at 11:43 PM David C. Petty wrote:**

Hi everyone! It's great to see that people are able to push to the repository. Here are some observations.

*  In general, any files related to anyone's personal setup (*i.e.* IDE files of any sort) are not relevant to the repository.
    *  Here's an example: in `.idea/modules.xml` is *\<module fileurl="file://$PROJECT_DIR$/src/main/main.iml" filepath="$PROJECT_DIR$/src/main/main.iml" /\>*, but each person's `main.iml` file will contain different window settings, *etc.* and so one person's version should not override another's.
    * In any case, a particular person's `.idea` directory should not be at the top level of the project, so I have moved the `.idea` directory to `src/misc/.idea` until everyone agrees that it should be removed entirely.
* <https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html> Describes the standard layout. Remember, in a Maven project, everything you are working on is in `src`. the rest of the stuff (mostly in `target`) will be built by Maven. The only files added to the .JAR file are those compiled from `src/main/java` and `src/main/resources`.
* Here are some tips for newbies:
    * When using `git add path`, always specify exactly which files you want to add... don't leave the path off the command. When in doubt, use `git status` and you will get a list of 'untracked files' that you can copy the paths from.
    * Maven requires packages. We have never used them in Java (they are not on the AP exam). <https://www.ibm.com/support/knowledgecenter/ssw_ibm_i_73/rzaha/clpckdir.htm> explains that the directory structure that must match the package structure. Therefore, the package minesweeper must be in `src/main/java/minesweeper`, *etc.* Also, there should be corresponding package structure in `src/main/test/`.
    * Always start your sessions with `git pull origin master` and end each session with `git commit -a` followed by `git push origin master`.
    * **Don't break the build!** Before committing any changes, `mvn clean package` should work without errors. Use `git status` to understand which files have been modified or added.
* Getting the newline characters right can be tricky. Please follow *Global settings for line endings*: <https://help.github.com/articles/dealing-with-line-endings/#platform-all>. If this setting is wrong, a file edited on Windows can be saved is such a way that `git` thinks every line has changed.

More later... have fun!

\- dcp
 
p.s. For those of you not on Discord, I posted the following tonight:
 
```
OK... I fixed the build! (And the repository.) Everyone should git pull origin master. If you are working on code in the src directory since your last pull, before you pull, do the following:
- Copy src to another name so that you will save any changes to the Java files you have been working on.
- git fetch --all 
- git reset --hard origin/master
 
Note: fetch is like pull, but with no merges. reset --hard will set you to the current latest branch. DO NOT DO THIS UNLESS YOU HAVE COPIED YOUR WORK ELSEWHERE because all changes to your local repository will be lost. 
 
If you haven't been editing code, simply use git pull origin master next time (and every time) you plan to start editing code.
```

---

**On Mon, Jun 11, 2018 at 4:39 PM David C. Petty wrote:**

<https://github.com/wps-2017-2018-apcs/whs/graphs/contributors>

Hey, guys & gals... few people seems to be pushing to the repository... it has been a week w/o much progress! Plus, I have almost pushed more commits than the rest of you combined. The best way to run a collaborative project is to collaborate. Push early and often. Share code and communicate. Just sayin'.

I added <https://logging.apache.org/log4j/2.x/> logging to the project with the latest commits. `git pull origin master` to update. It's easy to use... every class has a logger. just use `logger.info("HERE IS SOME INTERESTING INFORMATION")` whenever you want. You can also do 'printf-style' logging using '{}' as a placeholder, *e.g.* `logger.info("{}: x = {}, y = {}", getClass(), x, y);` for variables `x` & `y`. I also added a default log message in each constructor of `logger.info(this);` so as to log something. Have fun!
 
**ALSO**, *the latest `push` was broken*. I can't believe everyone is doing `git pull origin master; mvn clean package` at the beginning of every work session, or you would have seen these errors. What gives?!

\- dcp

p.s. <http://nautil.us/issue/21/information/the-man-who-tried-to-redeem-the-world-with-logic> I got this from Tim Peters today... fascinating!

---

**On Tue, Jun 12, 2018 at 1:41 AM David C. Petty wrote:**

Gotta `git pull origin master` this morning!

* I have been looking at the graphics and (while that is never my strong point), I have modeled some code after https://github.com/wps-2015-2016-apcs-a/snake and added / changed some files. Let me know if you have questions.
    * I have committed a resources folder (`src/main/resources/`) that includes the `jog4j` parameter file and some images. Feel free to modify or replace them! (Make sure you include sources in credits.txt, if you got them off the web.) I could not find `smile.gif` anywhere in the repository, so I added `felix.gif`. Feel free to replace it.
    * I added three classes: `Button`, `Grid`, & `Images`. `Button` and `Grid` are GUI components (perhaps like `Tile`?). `Images` is a utility class that handles images to put on the buttons.
    * I reworked `Main` to use a `GridBagLayout`. That allows the game window to be resizable. However, it is not perfect, but it works. It would be nice to resize the `Grid` with the `Frame`, but you will have to figure that out.
    * **The biggest question you will now have to deal with in this game is: how should you separate GUI from logic?** Currently, the grid can figure out which button was pushed and the current button event handler simply changes the background color on the clicked button to <span style="color:red;">red</span>, so you can see how the code works. However, should the status of each button (whether it's a mine or flag, whether it is covered, whether there is a number in it) be kept in the GUI button component or in a separate class so the GUI component can simply display the state of the non-GUI logic component? Usually GUI and logic are kept separate, but that is up to you.
    * You will now have to implement the game logic when someone clicks a button... and I'm not even sure what that is... again, it is  probably best to have the game logic separate from any GUI and simply have the GUI components query the game logic to figure out how to paint themselves when paintComponent(g) is invoked.
    * Lots of stuff is now logged... in every constructor and (it should be) in every event handler. Don't be freaked out by the volume of logging. It can be very helpful when trying to debug.
* Non-change changes:
    * I'm not sure we explicitly talked about coding conventions, but every collaborative project must follow them. It doesn't really matter what they are, as long as everyone agrees. An easy and common one is the *Oracle Java Coding Conventions* (<http://www.oracle.com/technetwork/java/codeconventions-150003.pdf>). In particular, *indentation should be 4 spaces*. If every person changes the indentation every time they edit, then every commit looks like there are massive changes when there may be none. *Please adjust your IDE accordingly*.
    * I already pointed out that you should follow <https://help.github.com/articles/dealing-with-line-endings/#platform-all> so that everyone will use consistent line-endings. Some people are *still* committing changes with additional <https://en.wikipedia.org/wiki/Carriage_return>s.
    * Trailing whitespace is another way to create invisible non-change changes. Please adjust your IDE to save *without trailing whitespace*. (Note: DrJava is particularly guilty of this &mdash; especially when you tabify &mdash; so you just have to be careful!)
* *To me, a minimal participation in the project would require that you be able to execute `git pull origin master; mvn clean package javadoc:javadoc exec:java` without error*{:.underline}. Just sayin'.

\- dcp
 
p.s. Don't forget to add your name to an `@author` tag if you have worked on a file! <br/>
p.p.s. Please write more comments.<br/>
p.p.p.s. Some people could be working on the test cases in the `src/test/` directory.

---

**On Fri, Jun 15, 2018 at 8:18 AM David C. Petty wrote:**

Hi, all...
 
<http://www.crisgdwrites.com/minesweeper-can-teach-life/> I updated `Images.java` and added images to the repository for all 11 images shown here. (I didn't make one for a blank tile... that's just no image.)
 
All files (including the .SVG files) are in the repository. These images should be square. Their original size is 600x600. I'm not really happy about how they look @ 20x20. Fee free to do better!
 
I changed `Button.java` to randomly show all 11 images. **THIS IS JUST TEST CODE** to see what the images look like… feel free to put in the real code!
 
\- dcp

---

**On Mon, Jun 18, 2018 at 8:51 AM, David C. Petty wrote:**

p.s. `mvn javadoc:javadoc` was broken, but most of the errors were self-explanatory and are now fixed &mdash; including ones I introduced. The tags are listed here along with specific coding conventions: <http://www.oracle.com/technetwork/articles/java/index-137868.html>. I was able to add tags for `@pre.cond`, `@post.cond`, and `@to.do` to the POM.<br/>
p.p.s. Good luck with your finals and finishing Minesweeper on Wednesday!

---

**On Fri, Jun 22, 2018 at 12:12 PM, David C. Petty wrote:**:

Greetings everyone! It has been great to have you as students. Here are my final thoughts:
* Aspen was kinda broken and I could not post grades. It is now fixed, so I have posted everything that I have. Your report cards will ship on Monday. Please let me know if you have any questions.
* I guess <https://github.com/wps-2017-2018-apcs/whs/> is as completed as it's gonna get? I still get a [NPE](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html) whenever I click anything, *mais c'est la vie*.
* <https://github.com/wps-2017-2018-apcs/whs/graphs/contributors> shows only 7 contributors (half of the class)... and only one person added their name to an `@author` tag. Not really what I was hoping for.

Anyway, have a great summer!

\- dcp

---

**On Sun, Jul 01, 2018 at 11:47 AM, David C. Petty wrote:**:

Hi, all... I have been experimenting w/ Github and trying to learn its documentation options. One goal was to have the Javadoc be available to the public, as well as any documents written in `src/`. Here is what I have found:
* <https://wps-2017-2018-apcs.github.io/whs/> is the URI for what they call `github-pages`. There are several ways to configure it, but I have configured it as (a) in the `master` branch and (b) in the `docs/` directory. The `docs/` directory is further configured as a <https://jekyllrb.com/> website, which Github supports serving. Furthermore, this is a repository-specific site just for `whs`.
* Maven can create a site (using `mvn site`) that is currently setup in the `pom.xml` to (a) include the Javadocs and (b) upload to the `docs/site/` directory served at <https://wps-2017-2018-apcs.github.io/whs/site/>. **Do not edit these files directly** &mdash; they are created by Maven and consist of reports and Javadocs.
* There is a also wiki option (for which I have added a couple pages) here: <https://github.com/wps-2017-2018-apcs/whs/wiki>.

All three of these are good options for documenting. I would recommend using the `github-pages` option, since all you have to do is add the markdown (<https://kramdown.gettalong.org/>) files to the `docs/` directory.

Have fun!

\- dcp