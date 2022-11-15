package edu.cs.tcu.chineselearningplatform.datainitializer;

import edu.cs.tcu.chineselearningplatform.dao.VocabRepository;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private VocabRepository vocabRepository;

    public DBDataInitializer(VocabRepository vocabRepository) {
        this.vocabRepository = vocabRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Vocab v1 = new Vocab();
        v1.setWord("无论");
        v1.setPinyin("wúlùn");
        v1.setType("conj.");
        v1.setMeaning("no matter what or how; regardless of whether");
        // v1.setLesson();

        Vocab v2 = new Vocab();
        v2.setWord("句");
        v2.setPinyin("jùm");
        v2.setType("m.w..");
        v2.setMeaning("measure word for phrases or sentences");
        // v2.setLesson();

        Vocab v3 = new Vocab();
        v3.setWord("熟悉");
        v3.setPinyin("shúxīadj");
        v3.setType("adj./v.");
        v3.setMeaning("to be familiar with; to know well");
        // v3.setLesson();

        Vocab v4 = new Vocab();
        v4.setWord("类似");
        v4.setPinyin("lèisì");
        v4.setType("adj./v.");
        v4.setMeaning("to be of the same sort as");
        // v4.setLesson();

        Vocab v5 = new Vocab();
        v5.setWord("常见");
        v5.setPinyin("chángjiàn");
        v5.setType("v.");
        v5.setMeaning("commonly seen");
        // v5.setLesson();

        Vocab v6 = new Vocab();
        v6.setWord("一般来说");
        v6.setPinyin("yībān láishuō");
        v6.setType("conj.");
        v6.setMeaning("generally speaking");
        // v6.setLesson();

        Vocab v7 = new Vocab();
        v7.setWord("正式");
        v7.setPinyin("zhèngshì");
        v7.setType("adj.");
        v7.setMeaning("formal; official");
        // v7.setLesson();

        Vocab v8 = new Vocab();
        v8.setWord("场合");
        v8.setPinyin("chǎnghé");
        v8.setType("n.");
        v8.setMeaning("situation; occasion; context");
        // v8.setLesson();

        Vocab v9 = new Vocab();
        v9.setWord("互相");
        v9.setPinyin("hùxiāng");
        v9.setType("adv.");
        v9.setMeaning("each other; mutually; mutual");
        // v9.setLesson();

        Vocab v10 = new Vocab();
        v10.setWord("另");
        v10.setPinyin("lìng");
        v10.setType("adv./p.n.");
        v10.setMeaning("other; another");
        // v10.setLesson();

        Vocab v11 = new Vocab();
        v11.setWord("情况");
        v11.setPinyin("qíngkuàng");
        v11.setType("n.");
        v11.setMeaning("circumstances; situation");
        // v11.setLesson();

        Vocab v12 = new Vocab();
        v12.setWord("陌生人");
        v12.setPinyin("mòshēng rén");
        v12.setType("n.");
        v12.setMeaning("stranger");
        // v12.setLesson();

        Vocab v13 = new Vocab();
        v13.setWord("当");
        v13.setPinyin("dāng");
        v13.setType("v./prep.");
        v13.setMeaning("to act as; when; during");
        // v13.setLesson();

        Vocab v14 = new Vocab();
        v14.setWord("需要");
        v14.setPinyin("xūyào");
        v14.setType("n./adj./v./aux.v.");
        v14.setMeaning("to need; need");
        // v14.setLesson();

        Vocab v15 = new Vocab();
        v15.setWord("比方说");
        v15.setPinyin("bǐfāng shuō");
        v15.setType("prep.");
        v15.setMeaning("for example; for instance");
        // v15.setLesson();

        Vocab v16 = new Vocab();
        v16.setWord("问路");
        v16.setPinyin("wènlù");
        v16.setType("v.o.");
        v16.setMeaning("to ask for directions");
        // v16.setLesson();

        Vocab v17 = new Vocab();
        v17.setWord("表示");
        v17.setPinyin("biǎoshì");
        v17.setType("v./n.");
        v17.setMeaning("to express; to indicate; expression");
        // v17.setLesson();

        Vocab v18 = new Vocab();
        v18.setWord("友好");
        v18.setPinyin("yǒuhǎo");
        v18.setType("adj.");
        v18.setMeaning("friendly");
        // v18.setLesson();

        Vocab v19 = new Vocab();
        v19.setWord("方式");
        v19.setPinyin("fāngshì");
        v19.setType("n.");
        v19.setMeaning("way; manner; mode");
        // v19.setLesson();

        Vocab v20 = new Vocab();
        v20.setWord("却");
        v20.setPinyin("què");
        v20.setType("adv./conj.");
        v20.setMeaning("but; yet; however; while");
        // v20.setLesson();

        Vocab v21 = new Vocab();
        v21.setWord("少见");
        v21.setPinyin("shǎojiàn");
        v21.setType("v./adj.");
        v21.setMeaning("rare");
        // v21.setLesson();

        Vocab v22 = new Vocab();
        v22.setWord("熟人");
        v22.setPinyin("shúrén");
        v22.setType("n.");
        v22.setMeaning("acquaintance; friend");
        // v22.setLesson();

        Vocab v23 = new Vocab();
        v23.setWord("之间");
        v23.setPinyin("zhī jiān");
        v23.setType("n.");
        v23.setMeaning("between; among; inter-");
        // v23.setLesson();

        Vocab v24 = new Vocab();
        v24.setWord("同事");
        v24.setPinyin("tóngshì");
        v24.setType("n.");
        v24.setMeaning("colleague; co-worker");
        // v24.setLesson();

        Vocab v25 = new Vocab();
        v25.setWord("经理");
        v25.setPinyin("jīnglǐ");
        v25.setType("n.");
        v25.setMeaning("manager; director");
        // v25.setLesson();

        Vocab v26 = new Vocab();
        v26.setWord("打招呼");
        v26.setPinyin("dǎzhāohū");
        v26.setType("v.o.");
        v26.setMeaning("to greet somebody by word or action");
        // v26.setLesson();

        Vocab v27 = new Vocab();
        v27.setWord("遇见");
        v27.setPinyin("yùjiàn");
        v27.setType("v.");
        v27.setMeaning("to meet");
        // v27.setLesson();

        Vocab v28 = new Vocab();
        v28.setWord("报告");
        v28.setPinyin("bàogào");
        v28.setType("n./v.");
        v28.setMeaning("to inform; to report; report; speech");
        // v28.setLesson();

        Vocab v29 = new Vocab();
        v29.setWord("表面");
        v29.setPinyin("biǎomiàn");
        v29.setType("n.");
        v29.setMeaning("surface");
        // v29.setLesson();

        Vocab v30 = new Vocab();
        v30.setWord("实际");
        v30.setPinyin("shíjì");
        v30.setType("n./adj.");
        v30.setMeaning("reality; actual");
        // v30.setLesson();

        Vocab v31 = new Vocab();
        v31.setWord("外企");
        v31.setPinyin("wàiqǐ");
        v31.setType("n.");
        v31.setMeaning("companies established in mainland China with direct investment from foreign entities abbreviation for 外资企业");
        // v31.setLesson();

        Vocab v32 = new Vocab();
        v32.setWord("白领");
        v32.setPinyin("báilǐng");
        v32.setType("n.");
        v32.setMeaning("white-collar worker");
        // v32.setLesson();

        Vocab v33 = new Vocab();
        v33.setWord("既...也...");
        v33.setPinyin("jì...yě");
        v33.setType("conj.");
        v33.setMeaning("both...(and...)");
        // v33.setLesson();

        Vocab v34 = new Vocab();
        v34.setWord("传统");
        v34.setPinyin("chuántǒng");
        v34.setType("n./adj.");
        v34.setMeaning("tradition; traditional");
        // v34.setLesson();

        Vocab v35 = new Vocab();
        v35.setWord("问候");
        v35.setPinyin("wènhòu");
        v35.setType("v.");
        v35.setMeaning("to send a greeting; to give one’s respects");
        // v35.setLesson();

        Vocab v36 = new Vocab();
        v36.setWord("现代");
        v36.setPinyin("xiàndài");
        v36.setType("n.");
        v36.setMeaning("modern times");
        // v36.setLesson();

        vocabRepository.save(v1);
        vocabRepository.save(v2);
        vocabRepository.save(v3);
        vocabRepository.save(v4);
        vocabRepository.save(v5);
        vocabRepository.save(v6);
        vocabRepository.save(v7);
        vocabRepository.save(v8);
        vocabRepository.save(v9);
        vocabRepository.save(v10);
        vocabRepository.save(v11);
        vocabRepository.save(v12);
        vocabRepository.save(v13);
        vocabRepository.save(v14);
        vocabRepository.save(v15);
        vocabRepository.save(v16);
        vocabRepository.save(v17);
        vocabRepository.save(v18);
        vocabRepository.save(v19);
        vocabRepository.save(v20);
        vocabRepository.save(v21);
        vocabRepository.save(v22);
        vocabRepository.save(v23);
        vocabRepository.save(v24);
        vocabRepository.save(v25);
        vocabRepository.save(v26);
        vocabRepository.save(v27);
        vocabRepository.save(v28);
        vocabRepository.save(v29);
        vocabRepository.save(v30);
        vocabRepository.save(v31);
        vocabRepository.save(v32);
        vocabRepository.save(v33);
        vocabRepository.save(v34);
        vocabRepository.save(v35);
        vocabRepository.save(v36);
    }
}
